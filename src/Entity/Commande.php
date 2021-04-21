<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Commande
 *
 * @ORM\Table(name="commande", indexes={@ORM\Index(name="fk_idClient", columns={"IdClient"})})
 * @ORM\Entity
 */
class Commande
{
    /**
     * @var int
     *
     * @ORM\Column(name="IdCommande", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idcommande;

    /**
     * @var string
     *
     * @ORM\Column(name="numc", type="string", length=20, nullable=false)
     */
    private $numc;

    /**
     * @var int
     *
     * @ORM\Column(name="IdClient", type="integer", nullable=false)
     */
    private $idclient;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="DateCom", type="date", nullable=false)
     */
    private $datecom;

    /**
     * @var float
     *
     * @ORM\Column(name="MontantCom", type="float", precision=10, scale=0, nullable=false)
     */
    private $montantcom;

    /**
     * @var string
     *
     * @ORM\Column(name="EtatCom", type="string", length=20, nullable=false)
     */
    private $etatcom;

    public function getIdcommande(): ?int
    {
        return $this->idcommande;
    }

    public function getNumc(): ?string
    {
        return $this->numc;
    }

    public function setNumc(string $numc): self
    {
        $this->numc = $numc;

        return $this;
    }

    public function getIdclient(): ?int
    {
        return $this->idclient;
    }

    public function setIdclient(int $idclient): self
    {
        $this->idclient = $idclient;

        return $this;
    }

    public function getDatecom(): ?\DateTimeInterface
    {
        return $this->datecom;
    }

    public function setDatecom(\DateTimeInterface $datecom): self
    {
        $this->datecom = $datecom;

        return $this;
    }

    public function getMontantcom(): ?float
    {
        return $this->montantcom;
    }

    public function setMontantcom(float $montantcom): self
    {
        $this->montantcom = $montantcom;

        return $this;
    }

    public function getEtatcom(): ?string
    {
        return $this->etatcom;
    }

    public function setEtatcom(string $etatcom): self
    {
        $this->etatcom = $etatcom;

        return $this;
    }


}
