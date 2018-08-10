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
<!-- Load an icon library to show a hamburger menu (bars) on small screens -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/menu.css">
<link rel="stylesheet" href="css/responsiveMenu.css">
<script src="js/responsiveMenu.js"></script>


<!-- CSS DatePicker -->
<link rel="stylesheet" href="css/jquery.datetimepicker.min.css">
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
		<div class="topnav" id="myTopnav">
			<a href="index.jsp" class="active">B&B</a> <a href="modal.jsp">Añadir
				registro</a>
				 <a href="#"><form action="Controlador3" method="GET">
					<label data-error="wrong" data-success="right" for="borrarxId">Borrar
						por ID:</label> <input name="deleteByIdInput" placeholder="ID"
						id="borrarxID" class="">
					<button class="btn " type="submit" name="btnDeleteRow"
						id="btnBorrar">Borrar fila</button>

				</form></a> <a href="#"><form action="Controlador2" method="get">
					<button type="submit" class="btn" name="btnDelete"
						id="eliminarRegistrosTabla" onclick="return eliminarSafe();">Eliminar
						registros DB y tabla</button>
				</form></a> <a href="javascript:void(0);" class="icon" onclick="myFunction()">
				<i class="fa fa-bars"></i>
			</a>
		</div>



		<table id="example"
			class="table table-striped table-bordered table-hover table-sm table-dark">
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
					<th>GananciaXclient</th>

				</tr>
			</thead>
			<tbody>
				<%
					ManagementDao md = new ManagementDao();
					ClientDao clientDao = new ClientDao();
					Client cli = new Client();
					List<Client> listClient = clientDao.clientList();
					for (Client client : listClient) {
				%>
				<tr>
					<td><%=client.getId()%></td>
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
					<td><%=client.getGananciaXcliente()%> <%
 	}
 %>
					<td></td>
				</tr>
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
					<th>GananciaXclient</th>


				</tr>
			</tfoot>
		</table>


	</div>
	<script>
		function eliminarSafe() {
			var eliminarRegistros = document
					.getElementById("eliminarRegistrosTabla");
			if (eliminarRegistros != null) {

				confirm = window
						.confirm("¿Está seguro de querer eliminar todos los registros de la tabla ?");
				if (confirm) {

					alert("Borrando....");

				} else {

					alert("No se ha borrado nada");
					return false;
				}

			}

		}
	</script>


	<script>
		$(document).ready(function() {
			$('#example').DataTable();

		});
	</script>


</body>
</html>





