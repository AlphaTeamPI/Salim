<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * User
 *
 * @ORM\Table(name="user", uniqueConstraints={@ORM\UniqueConstraint(name="UserName", columns={"UserName"})})
 * @ORM\Entity
 */
class User
{
    /**
     * @var int
     *
     * @ORM\Column(name="IDUser", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $iduser;

    /**
     * @var string
     *
     * @ORM\Column(name="UserName", type="string", length=20, nullable=false)
     */
    private $username;

    /**
     * @var string
     *
     * @ORM\Column(name="Password", type="string", length=20, nullable=false)
     */
    private $password;

    /**
     * @var string
     *
     * @ORM\Column(name="Email", type="string", length=20, nullable=false)
     */
    private $email;

    /**
     * @var string|null
     *
     * @ORM\Column(name="ImageUser", type="string", length=2000, nullable=true, options={"default"="NULL"})
     */
    private $imageuser = 'NULL';

    /**
     * @var string
     *
     * @ORM\Column(name="Role", type="string", length=20, nullable=false)
     */
    private $role;

    /**
     * @var \DateTime|null
     *
     * @ORM\Column(name="DateDeNaissance", type="date", nullable=true, options={"default"="NULL"})
     */
    private $datedenaissance = 'NULL';

    /**
     * @var int|null
     *
     * @ORM\Column(name="PasswordOublie", type="integer", nullable=true, options={"default"="NULL"})
     */
    private $passwordoublie = NULL;

    /**
     * @var int
     *
     * @ORM\Column(name="online", type="integer", nullable=false)
     */
    private $online;

    public function getIduser(): ?int
    {
        return $this->iduser;
    }

    public function getUsername(): ?string
    {
        return $this->username;
    }

    public function setUsername(string $username): self
    {
        $this->username = $username;

        return $this;
    }

    public function getPassword(): ?string
    {
        return $this->password;
    }

    public function setPassword(string $password): self
    {
        $this->password = $password;

        return $this;
    }

    public function getEmail(): ?string
    {
        return $this->email;
    }

    public function setEmail(string $email): self
    {
        $this->email = $email;

        return $this;
    }

    public function getImageuser(): ?string
    {
        return $this->imageuser;
    }

    public function setImageuser(?string $imageuser): self
    {
        $this->imageuser = $imageuser;

        return $this;
    }

    public function getRole(): ?string
    {
        return $this->role;
    }

    public function setRole(string $role): self
    {
        $this->role = $role;

        return $this;
    }

    public function getDatedenaissance(): ?\DateTimeInterface
    {
        return $this->datedenaissance;
    }

    public function setDatedenaissance(?\DateTimeInterface $datedenaissance): self
    {
        $this->datedenaissance = $datedenaissance;

        return $this;
    }

    public function getPasswordoublie(): ?int
    {
        return $this->passwordoublie;
    }

    public function setPasswordoublie(?int $passwordoublie): self
    {
        $this->passwordoublie = $passwordoublie;

        return $this;
    }

    public function getOnline(): ?int
    {
        return $this->online;
    }

    public function setOnline(int $online): self
    {
        $this->online = $online;

        return $this;
    }


}
