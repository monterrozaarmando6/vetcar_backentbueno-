# VetCare Backend - PostgreSQL + Spring Boot

Backend REST de demostración para el Sistema de Gestión Veterinaria, basado en los requerimientos del documento del proyecto. Incluye propietarios, mascotas, citas, consultas médicas, medicamentos y pagos.

## Requisitos
- Java 17 o superior
- Maven 3.8+
- PostgreSQL 14 o superior (o Docker)

## Ejecutar localmente
1. Crea una base de datos llamada `vetcare` en PostgreSQL.
2. En PowerShell configura:

```powershell
$env:DATABASE_URL="jdbc:postgresql://localhost:5432/vetcare"
$env:DB_USERNAME="postgres"
$env:DB_PASSWORD="TU_CLAVE"
mvn spring-boot:run
```

3. Abre `http://localhost:8080/api/health`.

Alternativa con Docker: `docker compose up --build`.

## Datos demostrativos
Al iniciar, si no existen registros, crea un propietario `Laura Gomez`, una mascota `Max` y un medicamento de prueba. Esto permite demostrar que los datos se almacenan en PostgreSQL. Puedes consultarlos en los endpoints GET.

## Endpoints
| Recurso | Ruta | Operaciones |
|---|---|---|
| Propietarios | `/api/owners` | GET, POST, GET/{id}, PUT/{id}, DELETE/{id} |
| Mascotas | `/api/pets` | CRUD, GET `/owner/{ownerId}` |
| Citas | `/api/appointments` | CRUD, GET `/pet/{petId}` |
| Consultas | `/api/consultations` | CRUD, GET `/pet/{petId}` (historial) |
| Medicamentos | `/api/medications` | CRUD |
| Pagos | `/api/payments` | CRUD |
| Estado | `/api/health` | GET |

Los identificadores `ownerId` y `petId` vinculan los registros entre módulos. Esta versión usa IDs escalares para simplificar la API de demostración; no implementa aún restricciones FK entre esas tablas.

## Pruebas
- Ejecuta `mvn test` para la prueba automatizada de persistencia con H2 en memoria.
- Importa `postman/VetCare.postman_collection.json` en Postman.
- Usa `GET /api/owners`, `GET /api/pets` y `GET /api/medications` para comprobar los datos iniciales.
- Crea un propietario con POST y luego vuelve a ejecutar GET para demostrar el almacenamiento.

## Render
1. Sube el proyecto a GitHub.
2. En Render crea un Web Service desde el repositorio.
3. Selecciona Docker (Render detecta el Dockerfile).
4. Crea una base PostgreSQL en Render, o usa una base PostgreSQL externa.
5. Copia la Internal Database URL de Render y úsala en `DATABASE_URL` si el backend y la base están en la misma región. Si usas URL externa, utiliza la External Database URL.
6. Agrega `DB_USERNAME`, `DB_PASSWORD` y `CORS_ALLOWED_ORIGINS` en Environment.
7. Despliega y prueba `https://TU-SERVICIO.onrender.com/api/health`.

Render puede tener costos o límites según el plan y la configuración vigente. Verifica el panel antes de crear recursos.

## Limitaciones importantes
Esta entrega es una base CRUD académica para demostración. No incluye autenticación, JWT, control real de roles, facturación electrónica, validación de disponibilidad de veterinarios, notificaciones ni auditoría completa. No ingreses datos reales sensibles ni la presentes como sistema de producción seguro. Las pruebas automatizadas no se han ejecutado en este entorno porque Maven no está instalado; ejecútalas en tu equipo con `mvn test`.
