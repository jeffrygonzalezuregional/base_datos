from flask import Flask, render_template, request, redirect
import mysql.connector

app = Flask(__name__)

# === CONFIGURACIÓN DE CONEXIÓN A TU BASE DE DATOS ===
DB_CONFIG = {
    "host": "192.168.56.10",
    "port": 3306,
    "user": "app_user",           # ← Tu usuario de MySQL
    "password": "jeffry.1988",  # ← Tu contraseña de MySQL
    "database": "mi_base_datos"
}

def obtener_conexion():
    return mysql.connector.connect(**DB_CONFIG)

# Página principal: formulario
@app.route("/", methods=["GET", "POST"])
def index():
    if request.method == "POST":
        # Recibir datos del formulario
        nombre = request.form["NOMBRE"]
        telefono = request.form["TELEFONO"]
        dpi = request.form["DPI"]

        # Insertar en la base de datos
        conexion = obtener_conexion()
        cursor = conexion.cursor()
        try:
            sql = "INSERT INTO personas (nombre, telefono, dpi) VALUES (%s, %s, %s)"
            cursor.execute(sql, (nombre, telefono, dpi))
            conexion.commit()
        except mysql.connector.IntegrityError:
            return "<h3 style='color:red;'>Error: El DPI ya está registrado</h3><a href='/'>Volver</a>"
        finally:
            cursor.close()
            conexion.close()

        return redirect("/mostrar")
    
    return render_template("index.html")

# Página para ver todos los datos guardados
@app.route("/mostrar")
def mostrar():
    conexion = obtener_conexion()
    cursor = conexion.cursor(dictionary=True)
    cursor.execute("SELECT * FROM personas")
    personas = cursor.fetchall()
    cursor.close()
    conexion.close()
    return render_template("mostrar.html", personas=personas)

if __name__ == "__main__":
    app.run(host='0.0.0.0', port= 5000, debug=True)
