USE [master]
GO
/****** Object:  Database [JAVA1_Projekt]    Script Date: 28.1.2021. 3:05:00 ******/
CREATE DATABASE [JAVA1_Projekt]

GO
ALTER DATABASE [JAVA1_Projekt] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [JAVA1_Projekt].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [JAVA1_Projekt] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [JAVA1_Projekt] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [JAVA1_Projekt] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [JAVA1_Projekt] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [JAVA1_Projekt] SET ARITHABORT OFF 
GO
ALTER DATABASE [JAVA1_Projekt] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [JAVA1_Projekt] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [JAVA1_Projekt] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [JAVA1_Projekt] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [JAVA1_Projekt] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [JAVA1_Projekt] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [JAVA1_Projekt] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [JAVA1_Projekt] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [JAVA1_Projekt] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [JAVA1_Projekt] SET  DISABLE_BROKER 
GO
ALTER DATABASE [JAVA1_Projekt] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [JAVA1_Projekt] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [JAVA1_Projekt] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [JAVA1_Projekt] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [JAVA1_Projekt] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [JAVA1_Projekt] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [JAVA1_Projekt] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [JAVA1_Projekt] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [JAVA1_Projekt] SET  MULTI_USER 
GO
ALTER DATABASE [JAVA1_Projekt] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [JAVA1_Projekt] SET DB_CHAINING OFF 
GO
ALTER DATABASE [JAVA1_Projekt] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [JAVA1_Projekt] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [JAVA1_Projekt] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [JAVA1_Projekt] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [JAVA1_Projekt] SET QUERY_STORE = OFF
GO
USE [JAVA1_Projekt]
GO
/****** Object:  Table [dbo].[Film]    Script Date: 28.1.2021. 3:05:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Film](
	[IDFilm] [int] IDENTITY(1,1) NOT NULL,
	[Naziv] [nvarchar](255) NULL,
	[Opis] [nvarchar](900) NULL,
	[OriginalniNaziv] [nvarchar](255) NULL,
	[Link] [nvarchar](255) NULL,
	[PlakatPutanja] [nvarchar](255) NULL,
	[Pocetak] [nvarchar](255) NULL,
	[Trajanje] [int] NULL,
	[PublishedDate] [nvarchar](90) NULL,
PRIMARY KEY CLUSTERED 
(
	[IDFilm] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Glumac]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Glumac](
	[IDGlumac] [int] IDENTITY(1,1) NOT NULL,
	[Ime_Prezime] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[IDGlumac] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GlumciFilm]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GlumciFilm](
	[IDGlumciFilm] [int] IDENTITY(1,1) NOT NULL,
	[GlumacID] [int] NULL,
	[FilmID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IDGlumciFilm] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Korisnik]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Korisnik](
	[IDKorisnik] [int] IDENTITY(1,1) NOT NULL,
	[Ime] [nvarchar](50) NULL,
	[Prezime] [nvarchar](50) NULL,
	[KorisnickoIme] [nvarchar](50) NULL,
	[TipKorisnikaID] [int] NULL,
	[Lozinka] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[IDKorisnik] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Redatelj]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Redatelj](
	[IDRedatelj] [int] IDENTITY(1,1) NOT NULL,
	[Ime_Prezime] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[IDRedatelj] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RedateljFilm]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RedateljFilm](
	[IDRedateljFilm] [int] IDENTITY(1,1) NOT NULL,
	[RedateljID] [int] NULL,
	[FilmID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IDRedateljFilm] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TipKorisnika]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TipKorisnika](
	[IDTipKorisnika] [int] IDENTITY(1,1) NOT NULL,
	[Naziv] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[IDTipKorisnika] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Zanr]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Zanr](
	[IDZanr] [int] IDENTITY(1,1) NOT NULL,
	[Naziv] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[IDZanr] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ZanrFilm]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ZanrFilm](
	[IDZanrFilm] [int] IDENTITY(1,1) NOT NULL,
	[ZanrID] [int] NULL,
	[FilmID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IDZanrFilm] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[GlumciFilm]  WITH CHECK ADD FOREIGN KEY([FilmID])
REFERENCES [dbo].[Film] ([IDFilm])
GO
ALTER TABLE [dbo].[GlumciFilm]  WITH CHECK ADD FOREIGN KEY([GlumacID])
REFERENCES [dbo].[Glumac] ([IDGlumac])
GO
ALTER TABLE [dbo].[Korisnik]  WITH CHECK ADD FOREIGN KEY([TipKorisnikaID])
REFERENCES [dbo].[TipKorisnika] ([IDTipKorisnika])
GO
ALTER TABLE [dbo].[RedateljFilm]  WITH CHECK ADD FOREIGN KEY([FilmID])
REFERENCES [dbo].[Film] ([IDFilm])
GO
ALTER TABLE [dbo].[RedateljFilm]  WITH CHECK ADD FOREIGN KEY([RedateljID])
REFERENCES [dbo].[Redatelj] ([IDRedatelj])
GO
ALTER TABLE [dbo].[ZanrFilm]  WITH CHECK ADD FOREIGN KEY([FilmID])
REFERENCES [dbo].[Film] ([IDFilm])
GO
ALTER TABLE [dbo].[ZanrFilm]  WITH CHECK ADD FOREIGN KEY([ZanrID])
REFERENCES [dbo].[Zanr] ([IDZanr])
GO
/****** Object:  StoredProcedure [dbo].[createFilm]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[createFilm]
	@Naziv NVARCHAR(300),
	@Opis NVARCHAR(900),
	@OriginalniNaziv NVARCHAR(300),
	@Link NVARCHAR(90),
	@PlakatPutanja NVARCHAR(300),
		@Pocetak NVARCHAR(255),
		@Trajanje int,
		@PublishedDate NVARCHAR(90),
	@Id INT OUTPUT
AS 
BEGIN 
	INSERT INTO Film VALUES(@Naziv, @Opis, @OriginalniNaziv, @Link, @PlakatPutanja,@Pocetak,@Trajanje,@PublishedDate)
	SET @Id = SCOPE_IDENTITY()
END
GO
/****** Object:  StoredProcedure [dbo].[createGlumac]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[createGlumac]
	@Ime_Prezime NVARCHAR(50)
AS
		INSERT INTO Glumac(Ime_Prezime) VALUES (@Ime_Prezime)
GO
/****** Object:  StoredProcedure [dbo].[createGlumacFilm]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[createGlumacFilm]
	@FilmID INT,
	@GlumacID INT
AS
set nocount on
INSERT INTO GlumciFilm(GlumacID, FilmID) VALUES (@GlumacID, @FilmID)
GO
/****** Object:  StoredProcedure [dbo].[createGlumci]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[createGlumci]
	@Ime_Prezime NVARCHAR(255),
	@GlumacID INT OUT
AS
IF EXISTS (SELECT IDGlumac FROM Glumac WHERE Ime_Prezime = @Ime_prezime)
	BEGIN
		SET @GlumacID = (SELECT IDGlumac FROM Glumac WHERE Ime_Prezime = @Ime_prezime)
		RETURN (1)
	END
ELSE (SELECT IDGlumac FROM Glumac WHERE Ime_Prezime = @Ime_prezime)
	BEGIN
		INSERT INTO Glumac(Ime_Prezime) VALUES (@Ime_Prezime) 
		SET @GlumacID = SCOPE_IDENTITY()
		RETURN (2)
	END
GO
/****** Object:  StoredProcedure [dbo].[createRedatelj]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[createRedatelj]
	@Ime_Prezime NVARCHAR(50)
AS
		INSERT INTO Redatelj(Ime_Prezime) VALUES (@Ime_Prezime)

GO
/****** Object:  StoredProcedure [dbo].[createRedateljFilm]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE PROCEDURE [dbo].[createRedateljFilm]
	@FilmID INT,
	@RedateljID INT
AS
set nocount on
INSERT INTO RedateljFilm(RedateljID, FilmID) VALUES (@RedateljID, @FilmID)
GO
/****** Object:  StoredProcedure [dbo].[createRedatelji]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
	CREATE PROCEDURE [dbo].[createRedatelji]
	@Ime_Prezime NVARCHAR(50),
	@RedateljID INT OUT
AS
IF EXISTS (SELECT IDRedatelj FROM Redatelj WHERE Ime_Prezime = @Ime_prezime)
	BEGIN
		SET @RedateljID = (SELECT IDRedatelj FROM Redatelj WHERE Ime_Prezime = @Ime_prezime)
		RETURN (1)
	END
ELSE (SELECT IDRedatelj FROM Redatelj WHERE Ime_Prezime = @Ime_prezime)
	BEGIN
		INSERT INTO Redatelj(Ime_Prezime) VALUES (@Ime_Prezime) 
		SET @RedateljID = SCOPE_IDENTITY()
		RETURN (2)
	END
GO
/****** Object:  StoredProcedure [dbo].[createZanr]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[createZanr]
	@Naziv NVARCHAR(50)
AS
		INSERT INTO Zanr(Naziv) VALUES (@Naziv)

GO
/****** Object:  StoredProcedure [dbo].[createZanrFilm]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[createZanrFilm]
	@FilmID INT,
	@ZanrID INT
AS
set nocount on
INSERT INTO ZanrFilm(ZanrID, FilmID) VALUES (@ZanrID, @FilmID)
GO
/****** Object:  StoredProcedure [dbo].[createZanrovi]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

	CREATE PROCEDURE [dbo].[createZanrovi]
	@Naziv NVARCHAR(50),
	@ZanrID INT OUT
AS
IF EXISTS (SELECT IDZanr FROM Zanr WHERE Naziv = @Naziv)
	BEGIN
		SET @ZanrID = (SELECT IDZanr FROM Zanr WHERE Naziv = @Naziv)
		RETURN (1)
	END

ELSE (SELECT IDZanr FROM Zanr WHERE Naziv = @Naziv)
	BEGIN
		INSERT INTO Zanr(Naziv) VALUES (@Naziv) 
		SET @ZanrID = SCOPE_IDENTITY()
		RETURN (2)
	END
GO
/****** Object:  StoredProcedure [dbo].[deleteFilm]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[deleteFilm]
	@IDFilm INT
AS
Delete from GlumciFilm where FilmID = @IDFilm
Delete from RedateljFilm where FilmID = @IDFilm
Delete from Film WHERE IDFilm = @IDFilm
GO
/****** Object:  StoredProcedure [dbo].[deleteGlumac]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[deleteGlumac]
	@IDGlumac INT
AS
Delete from GlumciFilm where GlumacID = @IDGlumac
Delete from Glumac WHERE IDGlumac = @IDGlumac
GO
/****** Object:  StoredProcedure [dbo].[DeletePodataka]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE proc [dbo].[DeletePodataka]

as
set nocount on
delete from ZanrFilm
DBCC CHECKIDENT ('ZanrFilm', RESEED, 0)
delete from RedateljFilm
DBCC CHECKIDENT ('RedateljFilm', RESEED, 0)
delete from GlumciFilm
DBCC CHECKIDENT ('GlumciFilm', RESEED, 0)
delete from Film
DBCC CHECKIDENT ('Film', RESEED, 0)
delete from Glumac
DBCC CHECKIDENT ('Glumac', RESEED, 0)

delete from Redatelj
DBCC CHECKIDENT ('Redatelj', RESEED, 0)

delete from Zanr
DBCC CHECKIDENT ('Zanr', RESEED, 0)

GO
/****** Object:  StoredProcedure [dbo].[deleteRedatelj]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[deleteRedatelj]
	@IDRedatelj INT
AS
Delete from RedateljFilm where RedateljID = @IDRedatelj
Delete from Redatelj WHERE IDRedatelj = @IDRedatelj
GO
/****** Object:  StoredProcedure [dbo].[deleteZanr]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[deleteZanr]
	@IDZanr INT
AS
Delete from ZanrFilm where ZanrID = @IDZanr
Delete from Zanr WHERE IDZanr = @IDZanr
GO
/****** Object:  StoredProcedure [dbo].[loginKorisnika]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[loginKorisnika] @korisnickoIme nvarchar(50), @lozinka nvarchar(50), @tipKorisnikaID int
as
select IDKorisnik, Ime, Prezime, TipKorisnikaID from Korisnik
where KorisnickoIme = @korisnickoIme AND Lozinka = @lozinka AND TipKorisnikaID = @tipKorisnikaID
GO
/****** Object:  StoredProcedure [dbo].[registracijaKorisnika]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE proc [dbo].[registracijaKorisnika] @korisnickoIme nvarchar(50), @lozinka nvarchar(50), @tipKorisnikaID int, @ime nvarchar(50), @prezime nvarchar(50),@Id INT OUTPUT
as
insert into Korisnik(Ime, Prezime, KorisnickoIme, TipKorisnikaID, Lozinka)
values(@ime, @prezime, @korisnickoIme, @tipKorisnikaID,@lozinka)
SET @Id = SCOPE_IDENTITY()
GO
/****** Object:  StoredProcedure [dbo].[selectFilm]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[selectFilm]
	@IDFilm INT
AS
SELECT IDFilm, Naziv, Opis, OriginalniNaziv, Link, PlakatPutanja, Pocetak, Trajanje, PublishedDate FROM Film WHERE IDFilm = @IDFilm

GO
/****** Object:  StoredProcedure [dbo].[selectFilmovi]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[selectFilmovi]
AS 
BEGIN 
	SELECT * FROM Film
END
GO
/****** Object:  StoredProcedure [dbo].[selectGlumac]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[selectGlumac]
	@IDGlumac INT
AS
SELECT * FROM Glumac WHERE IDGlumac = @IDGlumac

GO
/****** Object:  StoredProcedure [dbo].[selectGlumacbyFilmID]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[selectGlumacbyFilmID]
	@FilmID INT
AS
SELECT g.IDGlumac, g.Ime_Prezime FROM GlumciFilm AS gm
INNER JOIN Glumac AS g ON gm.GlumacID = g.IDGlumac
WHERE gm.FilmID = @FilmID
GO
/****** Object:  StoredProcedure [dbo].[selectGlumci]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[selectGlumci]
AS
SELECT * FROM Glumac


GO
/****** Object:  StoredProcedure [dbo].[selectRedatelj]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[selectRedatelj]
	@IDRedatelj INT
AS
SELECT * FROM Redatelj WHERE IDRedatelj = @IDRedatelj


GO
/****** Object:  StoredProcedure [dbo].[selectRedateljbyFilmID]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[selectRedateljbyFilmID]
	@FilmID INT
AS
SELECT g.IDRedatelj, g.Ime_Prezime FROM RedateljFilm AS gm
INNER JOIN Redatelj AS g ON gm.RedateljID = g.IDRedatelj
WHERE gm.FilmID = @FilmID


GO
/****** Object:  StoredProcedure [dbo].[selectRedatelji]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[selectRedatelji]
AS
SELECT * FROM Redatelj


GO
/****** Object:  StoredProcedure [dbo].[selectZanr]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[selectZanr]
	@IDZanr INT
AS
SELECT * FROM Zanr WHERE IDZanr = @IDZanr

GO
/****** Object:  StoredProcedure [dbo].[selectZanrbyFilmID]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[selectZanrbyFilmID]
	@FilmID INT
AS
SELECT g.IDZanr, g.Naziv FROM ZanrFilm AS gm
INNER JOIN Zanr AS g ON gm.ZanrID = g.IDZanr
WHERE gm.FilmID = @FilmID

GO
/****** Object:  StoredProcedure [dbo].[selectZanrovi]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[selectZanrovi]
AS
SELECT * FROM Zanr


GO
/****** Object:  StoredProcedure [dbo].[updateFilm]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[updateFilm]
@IDFilm int,
	@Naziv NVARCHAR(300),
	@Opis NVARCHAR(900),
	@OriginalniNaziv NVARCHAR(300),
	@Link NVARCHAR(90),
	@PlakatPutanja NVARCHAR(300),
		@Pocetak NVARCHAR(255),
		@Trajanje int,
		@PublishedDate NVARCHAR(90)
AS
UPDATE Film SET Naziv = @Naziv, Opis = @Opis, OriginalniNaziv = @OriginalniNaziv, Link = @Link, PlakatPutanja = @PlakatPutanja, Pocetak = @Pocetak, Trajanje = @Trajanje, PublishedDate =@PublishedDate WHERE IDFilm = @IDFilm


GO
/****** Object:  StoredProcedure [dbo].[updateGlumac]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[updateGlumac]
@IDGlumac int,
@Ime_Prezime nvarchar(255)
as
update Glumac set Ime_Prezime = @Ime_Prezime where IDGlumac = @IDGlumac
GO
/****** Object:  StoredProcedure [dbo].[updateRedatelj]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[updateRedatelj]
@IDRedatelj int,
@Ime_Prezime nvarchar(255)
as
update Redatelj set Ime_Prezime = @Ime_Prezime where IDRedatelj = @IDRedatelj
GO
/****** Object:  StoredProcedure [dbo].[updateZanr]    Script Date: 28.1.2021. 3:05:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROC [dbo].[updateZanr]
@IDZanr int,
@Naziv nvarchar(255)
as
update Zanr set Naziv = @Naziv where IDZanr = @IDZanr
GO
USE [master]
GO
ALTER DATABASE [JAVA1_Projekt] SET  READ_WRITE 
GO

use JAVA1_Projekt

INSERT INTO TipKorisnika(Naziv)
VALUES('Admin'),('Obicni korisnik')

INSERT INTO Korisnik(Ime, Prezime, KorisnickoIme, Lozinka, TipKorisnikaID)
VALUES('Obicni','Korisnik','Obicni','abc123',2),('Administrator','Korisnik','Admin','abc123',1)
