<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agent Tirage</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <!-- Custom CSS -->
    <style>
        /* Add your custom styles here */
        .btn-imprimer {
            background-color: #6a5acd;
            color: #fff;
        }
        body {
            background-color: #6a5acd; /* Dark blue or purple background */
            background-image: url('resources/images.jfif');
            background-size: cover; /* Cover the entire page */
            background-position: center; /* Center the background image */
            padding-top: 20px;
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

<div class="container mt-5">
    <h2 class="text-center mb-4">Demandes de Tirage</h2>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Document</th>
                <th>Nombre de Copies</th>
                <th>Date et Heure de Retrait</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="demande" items="${demandesTirage}">
                <tr>
                    <td>${demande.id}</td>
                    <td>${demande.document}</td>
                    <td>${demande.nombreCopies}</td>
                    <td>${demande.dateHeureRetrait}</td>
                    <td>

                        <!-- Button to trigger file download -->
                        <button class="btn btn-imprimer btn-sm" onclick="downloadDocument('${demande.document}')">
                            <i class="fas fa-print"></i> Imprimer
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!-- Bootstrap JS and its dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
<!-- Font Awesome for icons -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
<!-- JavaScript for downloading documents -->
<script>
    function downloadDocument(documentPath) {
        window.location.href = "${pageContext.request.contextPath}/download?file=" + encodeURIComponent(documentPath);
    }
</script>
</body>
</html>
