<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.reservationbb.pob.dao.ClientDao"%>
<%@ page import="com.reservationbb.pob.dao.ManagementDao"%>

<%@ page import="com.reservationbb.pob.model.*"%>

<%@ page import="java.util.*"%>
<%@ page import="java.time.*"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS DatePicker -->
<link rel="stylesheet" href="css/jquery.datetimepicker.min.css">
<!-- DATE JS -->
<script src="js/date.js"></script>
<!--Js datepicker-->
<script src="js/jquery.js"></script>
<script src="js/jquery.datetimepicker.full.js"></script>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- JS LIBRARIES -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script
	src=" https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js"></script>
<!-- CSS LIBRARIES -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css">
<!-- MODAL  -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Gestión de reservas</title>
</head>
<body>
	<div class="container">
		<h1 class ="aligncenter">Gestión de reservas PB Bed And Breakfast</h1>
		<table id="example" class="table table-striped table-bordered table-hover table-sm table-dark">
			<thead> 
			<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Apellidos</th>
					<th>Nacionalidad</th>
					<th>Teléfono</th>
					<th>Total habitaciones</th>
					<th>Total noches</th>
					<th>Precio por noche</th>
					<th>Depósito</th>
					<th>Check in</th>
					<th>Check Out</th>
	
				</tr>
			</thead>
			<tbody>
				<%
					ClientDao clientDao = new ClientDao();
					List<Client> listClient = clientDao.clientList();
	
					for (Client client : listClient) {
				%>
				<tr>
					<td><%=client.getId() %></td>
					<td><%=client.getName()%></td>
					<td><%=client.getSurname()%></td>
					<td><%=client.getNationality()%></td>
					<td><a href="tel:+34<%=client.getTelephone()%>"><%=client.getTelephone()%></a></td>
					<td><%=client.getTotalRooms()%></td>
					<td><%=client.getTotalNights()%></td>
					<td><%=client.getPricePerNight()%></td>
					<td><%=client.getDeposit()%></td>
					<!-- Ganancia total = (numeroHab * precioPorNoche) * totalNoches <td></td> -->
					<td><%=client.getCheckIn()%></td>
					<td><%=client.getCheckOut()%></td>
					
				</tr>
	
				<%
					}
				%>
	
			</tbody>
			<tfoot>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Apellidos</th>
					<th>Nacionalidad</th>
					<th>Tel</th>
					<th>Total hab</th>
					<th>Total noches</th>
					<th>Precio/p/n</th>
					<th>Depósito</th>
					<th>Check in</th>
					<th>Check Out</th>
	
				</tr>
			</tfoot>
		</table>
		<!-- Trigger the modal with a button -->
		<button type="button" class="btn btn-info btn-lg" data-toggle="modal"
			data-target="#myModal">Añadir cliente</button>
		<form action="Controlador" method="get"><button type="submit" class="btn btn-info btn-lg" name ="btnDelete">
		Eliminar registros DB y tabla</button></form>			
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
									<label data-error="wrong" data-success="right" for="nationality">Nacionalidad:</label>
									<i class="fa fa-envelope prefix grey-text"></i> <input
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
										class="fa fa-envelope prefix grey-text"></i> <input type="text"
										id="totalRooms" name="totalRooms" class="form-control validate">
								</div>
								<div class="md-form mb-5">
									<label data-error="wrong" data-success="right"
										for="totalHabitaciones">totalNights:</label> <i
										class="fa fa-envelope prefix grey-text"></i> <input type="text"
										id="totalRooms" name="totalNights"
										class="form-control validate">
								</div>
								<div style ="line-height:70px" class="form-inline md-form mb-5">
									<div class="form-group">
										<label data-error="wrong" data-success="right" for="checkIn">Check
											in:</label> <i class="fa fa-tag prefix grey-text"></i> <input
											type="date" onclick="fechaInicio()" value="" step=""
											name="checkIn" id="checkIn" min="<%=LocalDate.now()%>"
											max="<%=LocalDate.of(2019, 01, 01)%>"
											class="form-control validate">
		
											<label data-error="wrong" data-success="right" for="checkOut">Check
											out:</label> <i class="fa fa-tag prefix grey-text"></i> <input
											type="date" onclick="fechaCheckOut();" value="" name="checkOut"
											id="checkOut" min="<%=LocalDate.now()%>"
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
								<button type="submit" class="btn btn-primary">
									Enviar <i class="fa fa-paper-plane-o ml-1"></i>
								</button>
							</div>
							<button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>
						</div>
	
					</div>
				</div>
			</div>
		</form>
		<script>
			$(document).ready(function() {
				$('#example').DataTable();
					
			});
		</script>
		<!-- VALIDACION FORMULARIO  -->
		<script src="js\validate.js">
			
		</script>
	</div>	
</body>
</html>





