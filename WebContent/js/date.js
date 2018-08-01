// Fechas por defecto para las los inputs del formulario

var checkIn = new Date().toISOString().substr(0, 10);
function fechaInicio() {
	document.querySelector("#checkIn").value = checkIn;
	return checkIn;
}
function fechaCheckOut() {
	var checkOut = new Date();
	if (checkOut != null) {
		checkOut = checkIn;
		document.querySelector("#checkOut").value = checkOut;
		return checkOut;

	}
}

/*
 * Función que suma o resta días a una fecha, si el parámetro días es negativo
 * restará los días function sumarDias(fecha, dias){
 * fecha.setDate(fecha.getDate() + dias); return fecha; }
 */