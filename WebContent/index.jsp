<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.reservationbb.pob.dao.*"%>
<%@ page import="com.reservationbb.pob.model.*"%>

<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- JS LIBRARIES -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<!--<script src="reservationbb/WebContent/js/jquery-3.3.1.js"></script> -->
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js"></script>
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
<h1>Gestión de reservas PB Bed And Breakfast</h1>
	<table id="example" class="table table-striped table-bordered"
		style="width: 100%">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Apellidos</th>
				<th>Nacionalidad</th>
				<th>Teléfono</th>
				<th>Total habitaciones</th>
				<th>Total noches</th>
				<th>Precio por noche</th>
				<th>Ganancia total</th>
				<th>Check in</th>
				<th>Check Out</th>




			</tr>
		</thead>
		<tbody>
			<%
				ClientDao clientDao = new ClientDao();
				Management mg = new Management();
				List<Client> listClient = clientDao.clientList();
				
				for(Client client: listClient){
					%>
					<tr>
					<td><%=client.getId()%></td>
					<td><%=client.getName()%></td>
					<td><%=client.getSurname()%></td>
					<td><%=client.getNationality()%></td>
					<td><%=client.getTelephone()%></td>
					<td><%= mg.getNumberOfRooms() %></td>
					<td><%= mg.getTotalNights() %>
					<td><%=mg.getPricePerNight()%></td>
					<td>Ganancia total</td>
					<!-- Ganancia total = (numeroHab * precioPorNoche) * totalNoches <td></td> -->
					<td>reservationDate</td>
					<td>reservationEnd</td>
				</tr>
				
				<%} %>
					
		</tbody>
		<tfoot>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Apellidos</th>
				<th>Nacionalidad</th>
				<th>Teléfono</th>
				<th>Total habitaciones</th>
				<th>Total noches</th>
				<th>Precio por noche</th>
				<th>Ganancia total</th>
				<th>Check in</th>
				<th>Check Out</th>

			</tr>
		</tfoot>
	</table>
	<!-- Trigger the modal with a button -->
	<button type="button" class="btn btn-info btn-lg" data-toggle="modal"
		data-target="#myModal">Añadir cliente</button>
	<form action="Controlador" name="formInsertar" method="post">
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
									name="name" class="form-control validate">
							</div>

							<div class="md-form mb-5">
								<label data-error="wrong" data-success="right" for="surname">Apellidos:</label>
								<i class="fa fa-envelope prefix grey-text"></i> <input
									type="text" name="surname" class="form-control validate">
							</div>
							<div class="md-form mb-5">
								<label data-error="wrong" data-success="right" for="nationality">Nacionalidad:</label>
								<i class="fa fa-envelope prefix grey-text"></i> <input
									type="text" name="nationality" class="form-control validate">
							</div>

							<div class="md-form">
								<label data-error="wrong" data-success="right" for="tel">Teléfono:</label>
								<i class="fa fa-pencil prefix grey-text"></i> <input type="text"
									name="telephone" class="md-textarea form-control"></input>
							</div>
							<!-- <div class="md-form mb-5">
								<label data-error="wrong" data-success="right" for="checkIn">Check
									in:</label> <i class="fa fa-tag prefix grey-text"></i> <input
									type="text" name="checkIn" id="checkIn"
									class="form-control validate">
							</div>
							<div class="md-form mb-5">
								<label data-error="wrong" data-success="right" for="checkOut">Check
									out:</label> <i class="fa fa-tag prefix grey-text"></i> <input
									type="text" name="checkOut" id="checkOut"
									class="form-control validate">
							</div> -->
							<div class="md-form mb-5">
								<label data-error="wrong" data-success="right" for="checkOut">Adelanto</label>
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
</body>
</html>





