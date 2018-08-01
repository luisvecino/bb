function validate() {
	var name, surname, nationality, telephone, totalRooms, totalNights, deposit, checkIn, checkOut;
	name = document.getElementById("name").value;
	surname = document.getElementById("surname").value;
	nationality = document.getElementById("nationality").value;
	telephone = document.getElementById("telephone").value;
	totalRooms = document.getElementById("totalRooms").value;
	deposit = document.getElementById("deposit").value;
	checkIn = document.getElementById("checkIn").value;
	checkOut = document.getElementById("checkOut").value;

	if(name === "" || surname === "" || telephone === "" || totalRooms === "" || nationality === "" || deposit === "" || checkIn === "" || checkOut === ""){
		alert("Todos los campos son obligatorios");
		return false;
	}
	else if(name.length > 20){
		alert("El nombre es demasiado largo");
		return false;		
	}
	else if(surname.length > 40){
		alert("	Los apellidos son demasiado largos");
		return false;		
	}
	else if (nationality.length > 20){
		alert("La nacionalidad es demasiado larga");
		return false;
	}
	else if(telephone.length > 9){
		alert("El teléfono es demasiado largo");
		return false;		
	}
	else if(totalRooms > 5){
		alert("El máximo de habitaciones disponibles son 5");
		return false;		
	}
	else if(checkIn.length > 12){
		alert("Debe de insertar una fecha correcta para el check IN");
		return false;		
	}
	else if(checkOut.length > 12){
		alert("Debe de insertar una fecha correcta para el check OUT");
		return false;		
	}
	else if(deposit < 20){
		alert("El mínimo deposito son 20 Euros");
		return false;
	}


		

}