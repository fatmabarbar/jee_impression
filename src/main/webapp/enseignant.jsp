<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Gestion des Matières - Enseignant</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
            padding-top: 20px;
            background-image: url('resources/images.jfif'); /* Ajoutez votre chemin d'image */
            background-size: cover;
        }
        h2 {
            margin-bottom: 20px;
        }
        .modal-header {
            background-color: #007bff;
            color: white;
        }
        .modal-title {
            font-size: 1.5rem;
        }
        .modal-footer .btn-primary {
            background-color: #6f42c1;
        }
        .table th, .table td {
            vertical-align: middle;
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
    <h2>Mes Matières</h2>
    <table class="table table-striped table-hover">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Nombre d'étudiants</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="matiere" items="${matieres}">
            <tr>
                <td>${matiere.id}</td>
                <td>${matiere.nom}</td>
                <td>${matiere.nombreEtudiants}</td>
                <td>
                    <button class="btn btn-primary" data-toggle="modal" data-target="#uploadModal-${matiere.id}">
                        <i class="fas fa-upload"></i> Télécharger Document
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="uploadModal-${matiere.id}" tabindex="-1" role="dialog" aria-labelledby="uploadModalLabel-${matiere.id}" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="uploadModalLabel-${matiere.id}">Télécharger Document</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <form action="${pageContext.request.contextPath}/enseignant" method="post" enctype="multipart/form-data">
                                    <div class="modal-body">
                                        <input type="hidden" name="matiereId" value="${matiere.id}">
                                        <div class="form-group">
                                            <label for="document-${matiere.id}">Document:</label>
                                            <input type="file" id="document-${matiere.id}" name="document" class="form-control" accept="application/pdf" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="dateHeureRetrait-${matiere.id}">Date et Heure de Retrait:</label>
                                            <input type="datetime-local" id="dateHeureRetrait-${matiere.id}" name="dateHeureRetrait" class="form-control" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="nombreCopies-${matiere.id}">Nombre de Copies:</label>
                                            <input type="number" id="nombreCopies-${matiere.id}" name="nombreCopies" class="form-control" min="1" max="${matiere.nombreEtudiants}" required>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
                                        <input type="submit" value="Télécharger" class="btn btn-primary">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
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
