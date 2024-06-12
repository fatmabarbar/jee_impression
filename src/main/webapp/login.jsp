<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <!-- Ajout de styles personnalisés -->
    <style>
        body {
            background-image: url('resources/images.jfif'); /* Ajouter votre image de fond */
            background-size: cover; /* Ajuste la taille de l'image pour couvrir toute la fenêtre */
            background-color: #007bff; /* Couleur de fond en cas d'échec de l'image */
        }

        .container {
            margin-top: 100px; /* Marge par rapport au haut de la page */
        }

        .form-container {
            background-color: rgba(255, 255, 255, 0.8); /* Fond blanc transparent pour le formulaire */
            padding: 20px;
            border-radius: 10px; /* Coins arrondis */
            box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1); /* Ombre douce */
        }

        .form-container label {
            color: #000; /* Couleur du texte (noir) */
        }

        .form-container input[type="text"],
        .form-container input[type="password"] {
            background-color: #fff; /* Couleur de fond des champs de saisie (blanc) */
            color: #000; /* Couleur du texte (noir) */
        }

        .form-container input[type="submit"] {
            background-color: #6f42c1; /* Nouvelle couleur de fond du bouton (violet) */
            color: #fff; /* Couleur du texte (blanc) */
            border-color: #6f42c1; /* Couleur de la bordure (violet) */
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 form-container">
            <h2 class="text-center">Login</h2>
            <form action="${pageContext.request.contextPath}/login" method="post">
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="text" id="email" name="email" class="form-control">
                </div>
                <div class="form-group">
                    <label for="password">Mot de passe:</label>
                    <input type="password" id="password" name="password" class="form-control">
                </div>
                <div class="form-group">
                    <input type="submit" value="Login" class="btn btn-primary btn-block">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Include Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
