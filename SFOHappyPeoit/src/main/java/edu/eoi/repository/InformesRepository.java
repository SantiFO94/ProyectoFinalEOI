package edu.eoi.repository;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.eoi.entity.Gato;
import edu.eoi.entity.Mascota;
import edu.eoi.entity.Perro;
import edu.eoi.entity.Responsable;
import edu.eoi.entity.TipoDeMascota;
import edu.eoi.service.MascotaService;
import edu.eoi.service.ResponsableService;

public class InformesRepository {

	static MascotaService MascotaService = new MascotaService();
	static ResponsableService ResponsableService= new ResponsableService();

	public void generarInformes() {
		
		List<Mascota> mascotas = new ArrayList<Mascota>();
		List<Responsable> responsables = ResponsableService.recuperarResponsables();

		for(TipoDeMascota tipoDeMascotaTemporal : TipoDeMascota.values()) {
			mascotas = MascotaService.recuperarMascotas(tipoDeMascotaTemporal);
			escribirDocumentoHTML(tipoDeMascotaTemporal, mascotas, responsables);
			
		}
		mascotas = MascotaService.recuperarMascotas(null);
		escribirDocumentoHTML(null, mascotas, responsables);
		
	}
	
	private static void escribirDocumentoHTML(TipoDeMascota tipoDeMascotaTemporal, List<Mascota> mascotas, List<Responsable> responsables) {
		Integer numeroDeMascotas = mascotas.size();
		try {
			FileWriter fw = null;
			//Generar el objeto que creará y escribirá nuestro documento
			if(tipoDeMascotaTemporal == null) {
				fw = new FileWriter("HAPPYPEOIT_Mascotas_".concat(LocalDate.now().toString()).concat(".html"), true);
			}else {
				fw = new FileWriter("HAPPYPEOIT_".concat(tipoDeMascotaTemporal.toString()).concat("_").concat(LocalDate.now().toString()).concat(".html"), true);

			}
			
			String htmlTemplateWeb=guardarHTMLTemplateWeb();
			String htmlTemplateWebProcesado=procesarHTMLTemplateWeb(htmlTemplateWeb, numeroDeMascotas, tipoDeMascotaTemporal);
			fw.write(htmlTemplateWebProcesado);
				
			for(Mascota mascota : mascotas) {
				String htmlTemplateAnuncio=guardarHTMLTemplateAnuncio();
				String htmlTemplateAnuncioProcesado = procesarHTMLTemplateAnuncio(htmlTemplateAnuncio, mascota, responsables);
				
				fw.write(htmlTemplateAnuncioProcesado);

			}
			fw.close();
		} catch (IOException e) {
			System.out.println("Ha habido un problema modificando el archivo");;
		}
	}

	private static String procesarHTMLTemplateWeb(String htmlTemplateWeb, Integer numeroDeMascotas, TipoDeMascota tipoDeMascotaTemporal) {
		String htmlTemplateWebProcesado = htmlTemplateWeb;
		htmlTemplateWeb = htmlTemplateWeb.replace("$numerodemascotas", numeroDeMascotas.toString().concat(" "));
		try{
			htmlTemplateWeb = htmlTemplateWeb.replace("$mascotasenadopcion", tipoDeMascotaTemporal.toString().concat(" ").concat("buscan familia:"));

		}catch(NullPointerException e) {
			htmlTemplateWeb = htmlTemplateWeb.replace("$mascotasenadopcion",("Mascotas buscan familia:"));

		}

		return htmlTemplateWebProcesado;
	}
	
	private static String procesarHTMLTemplateAnuncio(String htmlTemplateAnuncio, Mascota mascota, List<Responsable> responsables) {

		String htmlTemplateAnuncioProcesado = htmlTemplateAnuncio;
		htmlTemplateAnuncioProcesado = htmlTemplateAnuncioProcesado.replace("$imagen", mascota.getImagen());
		htmlTemplateAnuncioProcesado = htmlTemplateAnuncioProcesado.replace("$nombre", mascota.getNombre());
		htmlTemplateAnuncioProcesado = htmlTemplateAnuncioProcesado.replace("$ubicacion", mascota.getUbicacion());
		htmlTemplateAnuncioProcesado = htmlTemplateAnuncioProcesado.replace("$descripcion", mascota.getDescripcion());

		switch (mascota.getTipoDeMascota()) {
		case PERRO:
			htmlTemplateAnuncio = htmlTemplateAnuncio.replace("$edad", ((Perro) mascota).getEdad());
			break;
		case GATO:
			htmlTemplateAnuncio = htmlTemplateAnuncio.replace("$edad", ((Gato) mascota).getEdad());
			break;
		default:
			htmlTemplateAnuncio = htmlTemplateAnuncio.replace("$edad", "No disponible");
			break;
		}
		for (Responsable responsable : responsables) {
			if (responsable.getId().equals(mascota.getIdResponsable())) {
				htmlTemplateAnuncio = htmlTemplateAnuncio.replace("$telefono", responsable.getTelefono().toString());
				htmlTemplateAnuncio = htmlTemplateAnuncio.replace("$responsable", responsable.getNombre());
			}
		}
		return htmlTemplateAnuncioProcesado;
	}
	private static String guardarHTMLTemplateWeb() {
		String htmlTemplateWeb =
				"<!DOCTYPE html>"
				+"<html>"
				+"<head>"
				+"<link rel=\"stylesheet\" href=\"https://st1.idealista.com/static/common/release/listing/listing.css?20201127111745\" type=\"text/css\">"
				+"<link rel=\"stylesheet\" href=\"https://st1.idealista.com/static/common/release/modules/logged-user.css?20201127111745\" type=\"text/css\">"
				+"</head>"
				+"<body>"

				+"<header id=\"main-header\" class=\" private help-center ide-header \" style = \"background-color:#E59866\"> <div class=\"col-ide-lg-12 col-ide-xl-12 content\"> <figure class=\"logo-container \"> <a href=\"/\" class=\"id-logo\"> <img alt=\"Happy Pet\" src=\"https://ww.logoinn.com/Log162280360/f932f224-ecaa-4334-a6f3-1d12b4cc33e6/outgoing/L_MJ_01.jpg\" title=\"idealista\"></a> </figure> <nav> <div class=\"user-info beamer\" > <span class=\"avatar-small-inline\" data-initials=\"S\" data-render-initials=\"false\" data-profileid=\"6039798\" data-avatarurl=\"/multimediaProfile/{userProfileId}\"><span class=\"no-avatar-icon icon-user\" ></span></span> <span class=\"user-info--username icon-arrow-dropdown\" >Santiago</span> </div> <ul class=\"submenu header-second-level-menu\" ><li> <a data-markup=\"header-your-profile\" href=\"/usuario/tus-datos/perfil\" title=\"cambia tus datos personales\" data-click=\"1\" > Tu perfil </a> </li><li> <a href=\"/contratos-de-alquiler\" title=\"Tus contratos\"> Tus mascotas </a> </li><li> <a data-markup=\"header-your-purchases\" href=\"/usuario/tus-compras\" title=\"Consulta tus compras, facturas y tarjetas\" data-click=\"1\"> Tus adopciones </a> </li><li> <a data-markup=\"header-your-discarded\" href=\"/usuario/eliminados/\" title=\"Gestiona tus descartados\" data-click=\"1\"> Tu historial </a> </li><li> <a data-markup=\"header-settings\" href=\"/usuario/tus-datos/notificaciones\" title=\"Configura tus notificaciones e idioma\" data-click=\"1\"> Ajustes </a> </li><li class=\"log-out\"> <a data-markup=\"header-log-out\" href=\"/logout\" title=\"Cerrar la sesiÃ³n de usuario\" data-click=\"1\"> Salir <span class=\"icon-exit\"></span> </a> </li></ul> </nav> </div> </header>"

				+"<h1 class=\"listing-title\" id=\"h1-container\"> <span class=\"h1-simulated\"> $numerodemascotas </span> $mascotasenadopcion </h1>"
				;
		return htmlTemplateWeb;
	}
	private static String guardarHTMLTemplateAnuncio() {
		String htmlTemplateAnuncio=
				"<article class=\"item item-multimedia-container\" data-adid=\"39658520\">" 
				+"<picture class=\"item-multimedia \">"  
				+"<div class=\"item-gallery\">"
				+"<div class=\"mask-wrapper is-clickable\">"
				+"<div class=\"mask galleryBoost\" style=\"touch-action: pan-y; user-select: none; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); transition-duration: 0s; transform: translateX(0px);\">"
				+"<div class=\"placeholder\" style=\"transform: translateX(-300px);\"></div>"
				+"<div class=\"placeholder\" style=\"transform: translateX(0px);\"><img src= \"$imagen\" alt=\"\" style=\"visibility: visible;\" class=\"vertical\"></div>"
				+"<div class=\"placeholder\" style=\"transform: translateX(300px);\"><img src= \"$imagen\" alt=\"\" style=\"visibility: visible;\" class=\"vertical\"></div>"
				+"</div>"
				+"</div>"
				+"</div>"
				+"</picture>" 

				+"<div class=\"item-info-container\"> "
				+"<a href=\"/inmueble/39658520/\" class=\"item-link\" title=\"Chalet en avenida d'Europa, Poble Nou - Montiboli, La Villajoyosa / Vila Joiosa\">$nombre</a>" 
				+"<div><span class=\"item-detail\"> <small>$ubicacion</small></span></div>"
				+"<div><span class=\"item-detail\"> <small> $edad </small></span></div>"
				+"<div class=\"row price-row clearfix\"> <span class=\"item-price h2-simulated\"> $telefono <span class=\"icon-phone item-not-clickable-phone\"></span></span> </div>"
				+"<div class=\"item-description description\"> <p class=\"ellipsis\"> $descripcion </p> </div>" 
				+"<div class=\"item-toolbar\"> <button class=\"icon-chat email-btn action-email fake-anchor\"><span>$responsable</span></button>"  
				+"</div>" 
				+"</div>" 
				+"</article>"

				+"</body>"
				+"</html>"
				;
		
		return htmlTemplateAnuncio;

	}
}
