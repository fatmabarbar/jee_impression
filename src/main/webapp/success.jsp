jsp
Copy code
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
<style>
    body {
        background-image: url('resources/images.jfif'); /* Ajouter votre image de fond */
        background-size: cover; /* Ajuste la taille de l'image pour couvrir toute la fenêtre */
        background-color: #007bff; /* Couleur de fond en cas d'échec de l'image */
    }
</style>
<div class="container d-flex justify-content-center">
    <div class="alert alert-success" role="alert">
        <h4 class="alert-heading"><i class="fas fa-check-circle"></i> Success!</h4>
        <p class="lead">${message}</p>
        <hr>
        <p class="mb-0">Tâche accomplie avec succès!</p>
    </div>
</div>

<!-- Bootstrap JS and its dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
<!-- Font Awesome -->
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
</body>
</html>