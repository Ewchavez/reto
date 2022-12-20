package services;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.parser.ParseException;
import utils.web.Hooks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PetStore  {
    Hooks hooks =new Hooks();
    public boolean validoElCodigoEspera(String arg0) {
        String responseCode= String.valueOf(models.PetStore.lastResponse.getStatusCode());

        utils.services.Hooks.setEvidence( responseCode );
        if (responseCode.equals(arg0)){
            return true;
        }
        return false;
    }


    public void ingresoMascota(String nombre) throws IOException, ParseException {
        RestAssured.baseURI=hooks.getSerenityParams("URL.PETAPIv3");
        HashMap headermap = new HashMap<>();
        headermap.put("accept", "application/json");
        headermap.put("Content-Type", "application/json");

        Random r = new Random();
        String idPet = String.valueOf(r.nextInt(1000) + 1);

        FileInputStream tramaconsulta = new FileInputStream(new File(hooks.getSerenityParams("FILE.JSON.INGRESARMASCOTA")));
        String tramaOriginal = IOUtils.toString(tramaconsulta, "UTF-8");
        tramaOriginal= tramaOriginal.replace("NAMEPET",nombre).replace("idPET",idPet);
        models.PetStore.idPet=idPet;


        Response response=given().relaxedHTTPSValidation()
                .headers(headermap)
                .and()
                .body(tramaOriginal )
                .when()
                .post()
                .then()
                .extract().response();

        models.PetStore.lastResponse=response;

        utils.services.Hooks.setEvidence( response.prettyPrint() );

    }

    public void realizoConsultaDeMascota() throws IOException {
        RestAssured.baseURI=hooks.getSerenityParams("URL.PETAPIv3")+"/"+models.PetStore.idPet;
        HashMap headermap = new HashMap<>();
        headermap.put("accept", "application/json");

        Response response=given().relaxedHTTPSValidation()
                .headers(headermap)
                .and()
                .when()
                .get()
                .then()
                .extract().response();
        models.PetStore.lastResponse=response;
        utils.services.Hooks.setEvidence( response.prettyPrint() );


    }

    public void modifoMascota() throws IOException {
        String idPet=models.PetStore.lastResponse.getBody().prettyPrint().toString();
        idPet=idPet.substring(idPet.indexOf("id")+5,idPet.indexOf(","));

        RestAssured.baseURI=hooks.getSerenityParams("URL.PETAPIv3");
        HashMap headermap = new HashMap<>();
        headermap.put("accept", "application/json");
        headermap.put("Content-Type", "application/json");

        FileInputStream tramaconsulta = new FileInputStream(new File(hooks.getSerenityParams("FILE.JSON.MODIFICARMASCOTA")));
        String tramaOriginal = IOUtils.toString(tramaconsulta, "UTF-8");

        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        tramaOriginal=tramaOriginal.replace("idPET",idPet);
        tramaOriginal=tramaOriginal.replace("newNamePET",generatedString);
        Response response=given().relaxedHTTPSValidation()
                .headers(headermap)
                .and()
                .body(tramaOriginal)
                .when()
                .put()
                .then()
                .extract().response();

        models.PetStore.lastResponse=response;
        utils.services.Hooks.setEvidence( response.prettyPrint() );


    }


    public void eliminarMascota() throws IOException {

        String idPet=models.PetStore.lastResponse.getBody().prettyPrint().toString();
        idPet=idPet.substring(idPet.indexOf("id")+5,idPet.indexOf(","));

        RestAssured.baseURI=hooks.getSerenityParams("URL.PETAPIv3")+"/"+idPet;
        HashMap headermap = new HashMap<>();
        headermap.put("accept", "*/*");


        Response response=given().relaxedHTTPSValidation()
                .headers(headermap)
                .and()
                .when()
                .delete()
                .then()
                .extract().response();

        models.PetStore.lastResponse=response;
        utils.services.Hooks.setEvidence( response.prettyPrint() );
    }

    public void eliminarMascota(String ApiKey) throws IOException {
        String idPet=models.PetStore.lastResponse.getBody().prettyPrint().toString();
        idPet=idPet.substring(idPet.indexOf("id")+5,idPet.indexOf(","));

        RestAssured.baseURI=hooks.getSerenityParams("URL.PETAPIv3")+"/"+idPet;
        HashMap headermap = new HashMap<>();
        headermap.put("accept", "*/*");
        headermap.put("api_key", ApiKey);


        Response response=given().relaxedHTTPSValidation()
                .headers(headermap)
                .and()
                .when()
                .delete()
                .then()
                .extract().response();

        models.PetStore.lastResponse=response;
        utils.services.Hooks.setEvidence( response.prettyPrint() );
    }

    public void obtenerMascotas(String estado) {
        RestAssured.baseURI=hooks.getSerenityParams("URL.PETAPIGETBYSTATUSv3") +estado;
        HashMap headermap = new HashMap<>();
        headermap.put("accept", "application/json");



        Response response=given().relaxedHTTPSValidation()
                .headers(headermap)
                .and()
                .when()
                .get(baseURI)
                .then()
                .extract().response();

        models.PetStore.lastResponse=response;
        utils.services.Hooks.setEvidence( response.prettyPrint() );

    }
}
