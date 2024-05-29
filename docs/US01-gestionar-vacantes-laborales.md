Como admin

Quiero agregar una vacante al sistema

Para publicar la oferta en el sitio web


### Criterios de aceptación
```gherkin
Scenario: admin agrega una nueva vacante

Given admin se encuentre en la sección "Recruitment > Vacancies"
When presione click sobre el botón Add
And envíe el formulario con los campos requeridos rellenos dejando la casilla "Publish in RSS Feed and Web Page" activada
Then aparece un toast message con el mensaje "Successfully Saved"
And se redirige a la página "Edit Vacancy"
And se agrega la vacante en la página "ApplyJobVacancy"
And se agrega el registro en la tabla de la página "ViewJobVacancy"
```
```gherkin
Scenario: admin edita una nueva vacante

Given admin se encuentre en la página "Edit Vacancy"
When presione click sobre el botón Add
And envíe el formulario con los campos requeridos rellenos dejando la casilla "Publish in RSS Feed and Web Page" activada
Then aparece un toast message con el mensaje "Successfully Saved"
And se registran los cambios en la página "ApplyJobVacancy"
```

### Reglas de negocio
**Add/Edit vacancy**: condiciones para agregar/editar vacante
- El campo _Vacancy Name_ debe contener al menos un caracter
  - si no tiene ningún caracter se visualiza un warning con el mensaje "Required"
- El campo _Job Title_ no debe tener seleccionada la opción --Select-- 
  - si se selecciona --Select-- se tomará como campo vacío y aparecerá la advertencia "Required"
- El text area _Description_ puede contener cualquier caracter alfanumérico, símbolo o estar vacío
- El campo Hiring Manager debe contener el nombre de personal registrado
- El campo _Number of Positions_ permite caracteres numéricos entre 1-99
  - si contiene un número fuera de ese rango se visualiza el warning "Should be a number between 1-99"
  - si se ingresa cualquier otro tipo de caracter se visualiza el warning "Should be a numeric value"