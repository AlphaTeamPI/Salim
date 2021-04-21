<?php

namespace App\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class CompteurController extends AbstractController
{
    /**
     * @Route("/compteur", name="compteur")
     */
    public function index(): Response
    {
        return $this->render('compteur/index.html.twig', [
            'controller_name' => 'CompteurController',
        ]);
    }
}
