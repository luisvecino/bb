<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.time.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!--  MODAL -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<!-- DATE JS -->
<script src="js/date.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html;  charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container jumbotron">
		<h1>Inserción de un nuevo cliente</h1>
		<p>Pulsando el botón podrá acceder al formulario para poder añadir
			un nuevo registro</p>
		<!-- Trigger the modal with a button -->
		<button type="button" class="btn btn-info btn-lg" data-toggle="modal"
			data-target="#myModal">Añadir cliente</button>
		<form action="Controlador" name="formInsertar" method="post"
			onsubmit="return validate();">
			<!-- Modal -->
			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title">Nuevo registro</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>

						<div class="modal-body">
							<div class="modal-body mx-3">
								<div class="md-form mb-5">
									<label data-error="wrong" data-success="right" for="name">Nombre:
									</label> <i class="fa fa-user prefix grey-text"></i> <input type="text"
										id="name" name="name" class="form-control validate">
								</div>

								<div class="md-form mb-5">
									<label data-error="wrong" data-success="right" for="surname">Apellidos:</label>
									<i class="fa fa-envelope prefix grey-text"></i> <input
										type="text" id="surname" name="surname"
										class="form-control validate">
								</div>
								<div class="md-form mb-5">
									<label data-error="wrong" data-success="right"
										for="nationality">Nacionalidad:</label> <i
										class="fa fa-envelope prefix grey-text"></i> <input
										type="text" id="nationality" name="nationality"
										class="form-control validate">
								</div>

								<div class="md-form">
									<label data-error="wrong" data-success="right" for="tel">Teléfono:</label>
									<i class="fa fa-pencil prefix grey-text"></i> <input type="tel"
										id="telephone" pattern="[0-9]{9}" name="telephone"
										class="md-textarea form-control"></input>
								</div>
								<div class="md-form mb-5">
									<label data-error="wrong" data-success="right"
										for="totalHabitaciones">nº hab:</label> <i
										class="fa fa-envelope prefix grey-text"></i> <input
										type="text" id="totalRooms" name="totalRooms"
										class="form-control validate">
								</div>
								<div class="md-form mb-5">
									<label data-error="wrong" data-success="right"
										for="totalHabitaciones">totalNights:</label> <i
										class="fa fa-envelope prefix grey-text"></i> <input
										type="text" id="totalRooms" name="totalNights"
										class="form-control validate">
								</div>
								<div style="line-height: 70px" class="form-inline md-form mb-5">
									<div class="form-group">
										<label data-error="wrong" data-success="right" for="checkIn">Check
											in:</label> <i class="fa fa-tag prefix grey-text"></i> <input
											type="date" onclick="fechaInicio()" value="" step=""
											name="checkIn" id="checkIn" min="<%=LocalDate.now()%>"
											max="<%=LocalDate.of(2019, 01, 01)%>"
											class="form-control validate"> <label
											data-error="wrong" data-success="right" for="checkOut">Check
											out:</label> <i class="fa fa-tag prefix grey-text"></i> <input
											type="date" onclick="fechaCheckOut();" value=""
											name="checkOut" id="checkOut" min="<%=LocalDate.now()%>"
											max="<%=LocalDate.of(2019, 01, 01)%>"
											class="form-control validate">

									</div>
								</div>


								<div class="md-form mb-5">
									<label data-error="wrong" data-success="right" for="deposit">Adelanto</label>
									<i class="fa fa-tag prefix grey-text"></i> <input type="text"
										name="deposit" id="deposit" class="form-control validate">
								</div>

							</div>

						</div>
						<div class="modal-footer">
							<div class="d-flex justify-content-center">
								<p>El precio de serie es 65€;</p>
								<input type ="text" name="inputPrice" placeholder="Nuevo precio" value ="65">
								<button type="submit" class="btn btn-primary">
									Enviar <i class="fa fa-paper-plane-o ml-1"></i>
								</button>


							</div>
							<button type="button" class="btn btn-primary"
								data-dismiss="modal">Cerrar</button>
						</div>

					</div>
				</div>
			</div>
		</form>


		<!-- VALIDACION FORMULARIO  -->
		<script src="js\validate.js"></script>

	</div>
</body>



</html>
