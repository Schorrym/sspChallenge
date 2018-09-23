package de.mariokramer.sspChallenge;

import de.mariokramer.sspChallenge.model.ObjektTyp;
import de.mariokramer.sspChallenge.model.SpielErgebnis;
import de.mariokramer.sspChallenge.model.SspChallengeModelComponent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = SspChallengeRestController.class)
public class SspChallengeRestControllerTest {

    @MockBean
    SspChallengeModelComponent sspChallengeModelComponent;

    @Autowired
    MockMvc mockMvc;

    @Before
    public void initMocks() {
        when(sspChallengeModelComponent.getErgebnis()).thenReturn(SpielErgebnis.verloren);
        when(sspChallengeModelComponent.getObjektTypSpieler()).thenReturn(ObjektTyp.Stein);
        when(sspChallengeModelComponent.getObjektTypComputer()).thenReturn(ObjektTyp.Schere);
    }

    @Test
    public void noSuchObjectExceptionTest() throws Exception {
        mockMvc.perform(get("/spielMit").param("objektName", "FakeObjekt").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().is4xxClientError())
                .andExpect(content().string("NoSuchObjectException - Kein Objekt namens 'FakeObjekt' gefunden"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    public void spielMitGegenstandTest() throws Exception {
        mockMvc.perform(get("/spielMit").param("objektName", "Schere").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));

        mockMvc.perform(get("/spielMit").param("objektName", "Stein").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));

        mockMvc.perform(get("/spielMit").param("objektName", "Papier").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));

        mockMvc.perform(get("/spielMit").param("objektName", "Brunnen").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }
}
