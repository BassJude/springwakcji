package pierzchala.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import pierzchala.model.Spittle;
import pierzchala.repository.SpittleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();

        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/"))
                .andExpect(view().name("home"));


        // prostsze ...
        assertEquals("home", controller.home());
    }

    @Test
    public void shouldShowRecentSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(20);
        SpittleRepository mockRepository =
                mock(SpittleRepository.class);
        when(mockRepository.findSpittles(Long.MAX_VALUE, 20))
                .thenReturn(expectedSpittles);
//        Tworzymy atrapę repozytorium
        SpittleController controller = new SpittleController(mockRepository);
//        SpittleController controller = new SpittleController(mockRepository);
//        Tworzymy atrapę Spring MVC
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(
                        new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();
//        Pobieramy listę spittle’ów
        mockMvc.perform(get("/spittles"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
//        Weryfikujemy wyniki
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }

//    @Test
//    public void testSpittle() throws Exception {
//        Spittle expectedSpittle = new Spittle("Hello", new Date());
//        SpittleRepository mockRepository = mock(SpittleRepository.class);
//        when(mockRepository.findOne(12345)).thenReturn(expectedSpittle);
//        SpittleController controller = new SpittleController(mockRepository);
//        MockMvc mockMvc = standaloneSetup(controller).build();
//        Żądanie pobrania zasobu na podstawie ścieżki
//        mockMvc.perform(get("/spittles/12345"))
//                .andExpect(view().name("spittle"))
//                .andExpect(model().attributeExists("spittle"))
//                .andExpect(model().attribute("spittle", expectedSpittle));
//    }
}