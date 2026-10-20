from flask import Flask, render_template, request, redirect, jsonify
import pymysql

app = Flask(__name__)

# CONFIGURACIÓN DE TU BASE DE DATOS REMOTA
db_config = {
    "host": "192.168.56.10",
    "user": "app_user",
    "password": "jeffry.1988",
    "database": "mi_base_datos",
    "charset": "utf8mb4"
}

def get_db_connection():
    return pymysql.connect(**db_config)

# Verificar conexión
def probar_db():
    try:
        conn = get_db_connection()
        conn.close()
        return True
    except Exception as e:
        print("Error de conexión:", e)
        return False

# PÁGINA PRINCIPAL - FORMULARIO
@app.route("/", methods=["GET", "POST"])
def inicio():
    bd_ok = probar_db()
    if not bd_ok:
        return " No se puede conectar a la base de datos. Revisa la IP, usuario y contraseña."
    
    if request.method == "POST":
        nombre = request.form["nombre"]
        telefono = request.form["telefono"]
        dpi = request.form["dpi"]

        conn = get_db_connection()
        cursor = conn.cursor()
        try:
            cursor.execute(
                "INSERT INTO personas (nombre, telefono, dpi) VALUES (%s, %s, %s)",
                (nombre, telefono, dpi)
            )
            conn.commit()
        except Exception as e:
            conn.rollback()
            return f" Error al guardar: {e}"
        finally:
            cursor.close()
            conn.close()
        
        return redirect("/datos")
    
    return render_template("index.html")

# PÁGINA PARA VER TODOS LOS REGISTROS
@app.route("/datos")
def mostrar_datos():
    bd_ok = probar_db()
    if not bd_ok:
        return " Sin conexión a la base de datos."
    
    conn = get_db_connection()
    cursor = conn.cursor(dictionary=True)
    cursor.execute("SELECT * FROM personas ORDER BY id DESC")
    personas = cursor.fetchall()
    cursor.close()
    conn.close()
    
    return render_template("mostrar_datos.html", personas=personas)

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000, debug=True)