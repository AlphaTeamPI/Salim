<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Panier
 *
 * @ORM\Table(name="panier")
 * @ORM\Entity
 */
class Panier
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var int
     *
     * @ORM\Column(name="id_client", type="integer", nullable=false)
     */
    private $idClient;

    /**
     * @var string
     *
     * @ORM\Column(name="nom_prod", type="string", length=255, nullable=false)
     */
    private $nomProd;

    /**
     * @var float
     *
     * @ORM\Column(name="prix_prod", type="float", precision=10, scale=0, nullable=false)
     */
    private $prixProd;

    /**
     * @var int
     *
     * @ORM\Column(name="qte_prod", type="integer", nullable=false)
     */
    private $qteProd;

    /**
     * @var string|null
     *
     * @ORM\Column(name="image_prod", type="string", length=255, nullable=true, options={"default"="NULL"})
     */
    private $imageProd = 'NULL';

    /**
     * @var int
     *
     * @ORM\Column(name="refP", type="integer", nullable=false)
     */
    private $refp;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getIdClient(): ?int
    {
        return $this->idClient;
    }

    public function setIdClient(int $idClient): self
    {
        $this->idClient = $idClient;

        return $this;
    }

    public function getNomProd(): ?string
    {
        return $this->nomProd;
    }

    public function setNomProd(string $nomProd): self
    {
        $this->nomProd = $nomProd;

        return $this;
    }

    public function getPrixProd(): ?float
    {
        return $this->prixProd;
    }

    public function setPrixProd(float $prixProd): self
    {
        $this->prixProd = $prixProd;

        return $this;
    }

    public function getQteProd(): ?int
    {
        return $this->qteProd;
    }

    public function setQteProd(int $qteProd): self
    {
        $this->qteProd = $qteProd;

        return $this;
    }

    public function getImageProd(): ?string
    {
        return $this->imageProd;
    }

    public function setImageProd(?string $imageProd): self
    {
        $this->imageProd = $imageProd;

        return $this;
    }

    public function getRefp(): ?int
    {
        return $this->refp;
    }

    public function setRefp(int $refp): self
    {
        $this->refp = $refp;

        return $this;
    }


}
