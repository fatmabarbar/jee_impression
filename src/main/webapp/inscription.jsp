<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inscription</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f0f8ff; /* Bleu clair */
            background-image: url('resources/images.jfif'); /* Ajoutez votre chemin d'image */
            background-size: cover; /* Ajuste la taille de l'image pour couvrir toute la fenêtre */
        }
        .container {
            background-color: rgba(255, 255, 255, 0.8); /* Fond blanc transparent pour le contenu */
            padding: 20px;
            border-radius: 10px;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }
        .form-check {
            padding-left: 0; /* Ajuste la marge des cases à cocher */
        }
        .btn-primary {
            background-color: #6f42c1; /* Violet */
            border-color: #6f42c1; /* Couleur de la bordure */
        }
    </style>
</head>
<body>
<div class="container">
    <h2 class="text-center">Inscription</h2>
    <form action="${pageContext.request.contextPath}/inscription" method="post">
        <div class="form-group">
            <label for="nom">Nom:</label>
            <input type="text" class="form-control" id="nom" name="nom" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="motDePasse">Mot de Passe:</label>
            <input type="password" class="form-control" id="motDePasse" name="motDePasse" required>
        </div>
        <div class="form-group">
            <label for="role">Role:</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="role" id="enseignant" value="ENSEIGNANT" checked>
                <label class="form-check-label" for="enseignant">Enseignant</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="role" id="agentTirage" value="AGENT_TIRAGE">
                <label class="form-check-label" for="agentTirage">Agent de Tirage</label>
            </div>
        </div>
        <button type="submit" class="btn btn-primary btn-block">Inscription</button>
    </form>
</div>

<!-- Bootstrap JS and its dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
