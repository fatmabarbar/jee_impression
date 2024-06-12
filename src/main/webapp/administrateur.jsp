<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Administrateur</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <style>
        body {
            background-color: #6a5acd; /* Dark blue or purple background */
            background-image: url('resources/images.jfif');
            background-size: cover; /* Cover the entire page */
            background-position: center; /* Center the background image */
            padding-top: 20px;
        }
        .container {
            background-color: rgba(255, 255, 255, 0.8); /* Transparent white background for the content */
            border-radius: 10px;
            padding: 20px;
            margin-bottom: 20px;
        }
        .btn-action {
            margin-right: 5px; /* Spacing between buttons */
        }
        .btn-warning {
            background-color: #6a5acd; /* Dark blue or purple */
            border-color: #6a5acd; /* Dark blue or purple */
        }
        .btn-success {
            background-color: #6a5acd; /* Dark blue or purple */
            border-color: #6a5acd; /* Dark blue or purple */
        }
        .btn-primary {
            background-color: #6a5acd; /* Dark blue or purple */
            border-color: #6a5acd; /* Dark blue or purple */
        }
        .btn-primary:hover,
        .btn-warning:hover,
        .btn-success:hover {
            background-color: #483d8b; /* Darken the color on hover */
            border-color: #483d8b; /* Darken the color on hover */
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: transparent;">
    <a class="navbar-brand" href="#">Gestion Impression</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/logout">Déconnexion</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <h2>Administrateur</h2>
    <a href="${pageContext.request.contextPath}/inscription.jsp" class="btn btn-primary mb-3">Ajouter un utilisateur</a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Email</th>
            <th>Role</th>
            <th>Active</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.nom}</td>
                <td>${user.email}</td>
                <td>${user.role}</td>
                <td>${user.active ? 'Active' : 'Inactive'}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/administrateur" method="post">
                        <input type="hidden" name="id" value="${user.id}">
                        <c:choose>
                            <c:when test="${user.active}">
                                <input type="hidden" name="action" value="deactivate">
                                <input type="submit" value="Deactivate" class="btn btn-warning btn-action">
                            </c:when>
                            <c:otherwise>
                                <input type="hidden" name="action" value="activate">
                                <input type="submit" value="Activate" class="btn btn-success btn-action">
                            </c:otherwise>
                        </c:choose>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Bootstrap JS and its dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
