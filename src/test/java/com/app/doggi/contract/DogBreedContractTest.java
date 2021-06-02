package com.app.doggi.contract;

import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.PactBroker;
import au.com.dius.pact.provider.junitsupport.loader.PactBrokerAuth;
import au.com.dius.pact.provider.spring.junit5.MockMvcTestTarget;
import com.app.doggi.controller.ColorRestController;
import com.app.doggi.controller.DogBreedRestController;
import com.app.doggi.controller.NatureRestController;
import com.app.doggi.controller.dtos.stdin.DogBreedStdInDto;
import com.app.doggi.controller.dtos.stdout.DogBreedStdOutDto;
import com.app.doggi.model.Color;
import com.app.doggi.model.DogBreed;
import com.app.doggi.model.Nature;
import com.app.doggi.service.implementation.ColorServiceImpl;
import com.app.doggi.service.implementation.DogBreedServiceImpl;
import com.app.doggi.service.implementation.NatureServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;


@PactBroker(
        url = "https://laura.pactflow.io/",
        authentication = @PactBrokerAuth(token = "ky047qn-0gt2zPzuGNiQ5Q")
)
@Provider("DogAppBackend")
@ExtendWith(MockitoExtension.class)
public class DogBreedContractTest {

    @Mock
    private DogBreedServiceImpl dogBreedService;

    @InjectMocks
    private DogBreedRestController dogBreedRestController;


    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    public void pactVerificationTestTemplate(PactVerificationContext context) {
        context.verifyInteraction();
    }

    @BeforeEach
    public void changeContext(PactVerificationContext context) {
        MockMvcTestTarget testTarget = new MockMvcTestTarget();
        testTarget.setControllers(dogBreedRestController);
        context.setTarget(testTarget);
    }


    @State("list dog breeds")
    public void lisDogBreeds() {

        DogBreedStdOutDto dogBreedDto = new DogBreedStdOutDto();
        dogBreedDto.setId(78L);
        dogBreedDto.setName("Siberian Husky");
        dogBreedDto.setCountry("United Kingdom");
        dogBreedDto.setHeight(40);
        dogBreedDto.setWeight(20);

        Color color = new Color();
        color.setId(1L);
        color.setName("Red");
        Nature nature  = new Nature();
        nature.setId(1L);
        nature.setName("Intelligent");

        ArrayList<Color> colors = new ArrayList<>();
        colors.add(color);
        dogBreedDto.setDogBreedColors(colors);
        ArrayList<Nature> natures = new ArrayList<>();
        natures.add(nature);
        dogBreedDto.setDogBreedNatures(natures);

        List<DogBreedStdOutDto> dogBreedStdOutDtos = new ArrayList<>();
        dogBreedStdOutDtos.add(dogBreedDto);

        Mockito.when(dogBreedService.findAll()).thenReturn(dogBreedStdOutDtos);

    }


    @State("delete existing dog breed")
    public void deleteDogBreed(){
        DogBreedStdOutDto dogBreedDto = new DogBreedStdOutDto();
        dogBreedDto.setId(1L);
        dogBreedDto.setName("Siberian Husky");
        dogBreedDto.setCountry("United Kingdom");
        dogBreedDto.setHeight(40);
        dogBreedDto.setWeight(20);

        Color color = new Color();
        color.setId(1L);
        color.setName("Red");
        Nature nature  = new Nature();
        nature.setId(1L);
        nature.setName("Intelligent");

        ArrayList<Color> colors = new ArrayList<>();
        colors.add(color);
        dogBreedDto.setDogBreedColors(colors);
        ArrayList<Nature> natures = new ArrayList<>();
        natures.add(nature);
        dogBreedDto.setDogBreedNatures(natures);

        Mockito.when(dogBreedService.delete(1L)).thenReturn(dogBreedDto);

    }

    @State("create new dog breed")
    public void  saveDogBreed(){

        DogBreedStdOutDto dogBreedStdOutDto = new DogBreedStdOutDto();
        dogBreedStdOutDto.setHeight(31.0);
        dogBreedStdOutDto.setWeight(35.0);
        dogBreedStdOutDto.setLifeExpectancy(9);
        dogBreedStdOutDto.setName("Beagle");
        dogBreedStdOutDto.setId(1L);
        dogBreedStdOutDto.setCountry("Reino unido");
        Color colorRed = new Color();
        colorRed.setId(1L);
        colorRed.setName("Red");
        Color colorBlack = new Color();
        colorBlack.setId(2L);
        colorBlack.setName("Black");
        Color colorBrindle = new Color();
        colorBrindle.setName("Brindle");
        colorBrindle.setId(3L);
        List<Color> colorsDogBreed = new ArrayList<>();
        colorsDogBreed.add(colorRed);
        colorsDogBreed.add(colorBlack);
        colorsDogBreed.add(colorBrindle);
        Nature nature1 = new Nature();
        Nature nature2 = new Nature();
        Nature nature3 = new Nature();
        nature1.setId(1L);
        nature1.setName("sweet-tempered");
        nature2.setName("Trainable");
        nature2.setId(2L);
        nature3.setName("Stubborn");
        nature3.setId(3L);
        List<Nature> naturesDogBreed = new ArrayList<>();
        naturesDogBreed.add(nature1);
        naturesDogBreed.add(nature2);
        naturesDogBreed.add(nature3);
        dogBreedStdOutDto.setDogBreedNatures(naturesDogBreed);
        dogBreedStdOutDto.setDogBreedColors(colorsDogBreed);
        Mockito.when(dogBreedService.save(Mockito.any(DogBreedStdInDto.class))).thenReturn(dogBreedStdOutDto);

    }

    @State("edit existing dog breed")
    public void  updateDogBreed(){

        DogBreedStdOutDto dogBreedStdOutDto = new DogBreedStdOutDto();
        dogBreedStdOutDto.setHeight(31.0);
        dogBreedStdOutDto.setWeight(35.0);
        dogBreedStdOutDto.setLifeExpectancy(9);
        dogBreedStdOutDto.setName("Beagle");
        dogBreedStdOutDto.setId(1L);
        dogBreedStdOutDto.setCountry("Reino unido");
        Color colorRed = new Color();
        colorRed.setId(1L);
        colorRed.setName("Red");
        Color colorBlack = new Color();
        colorBlack.setId(2L);
        colorBlack.setName("Black");
        Color colorBrindle = new Color();
        colorBrindle.setName("Brindle");
        colorBrindle.setId(3L);
        List<Color> colorsDogBreed = new ArrayList<>();
        colorsDogBreed.add(colorRed);
        colorsDogBreed.add(colorBlack);
        colorsDogBreed.add(colorBrindle);
        Nature nature1 = new Nature();
        Nature nature2 = new Nature();
        Nature nature3 = new Nature();
        nature1.setId(1L);
        nature1.setName("sweet-tempered");
        nature2.setName("Trainable");
        nature2.setId(2L);
        nature3.setName("Stubborn");
        nature3.setId(3L);
        List<Nature> naturesDogBreed = new ArrayList<>();
        naturesDogBreed.add(nature1);
        naturesDogBreed.add(nature2);
        naturesDogBreed.add(nature3);
        dogBreedStdOutDto.setDogBreedNatures(naturesDogBreed);
        dogBreedStdOutDto.setDogBreedColors(colorsDogBreed);
        Mockito.when(dogBreedService.update(Mockito.any(Long.class),Mockito.any(DogBreedStdInDto.class))).thenReturn(dogBreedStdOutDto);

    }





}
