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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = SspChallengeController.class)
public class SspChallengeControllerTest {

    @MockBean
    SspChallengeModelComponent sspChallengeModelComponent;

    @Autowired
    MockMvc mockMvc;

    @Before
    public void initMocks() {
        when(sspChallengeModelComponent.getErgebnis()).thenReturn(SpielErgebnis.gewonnen);
        when(sspChallengeModelComponent.getObjektTypSpieler()).thenReturn(ObjektTyp.Schere);
        when(sspChallengeModelComponent.getObjektTypComputer()).thenReturn(ObjektTyp.Papier);
    }

    @Test
    public void newGameHTMLAufrufbarTest() throws Exception {
        mockMvc.perform(get("/newGame").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(view().name("newGame"))
                .andExpect(xpath("/html/body/p").nodeCount(3));
    }

    @Test
    public void newGameMitGegenstandTest() throws Exception {
        mockMvc.perform(get("/newGame/schere").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(view().name("newGame"))
                .andExpect(xpath("/html/body/p[1]").string("Deine Auswahl: Schere"))
                .andExpect(xpath("/html/body/p[2]").string("Computer Auswahl: Papier"))
                .andExpect(xpath("/html/body/p[3]").string("Der Spielausgang ist: gewonnen !"));
    }

    @Test
    public void simpleURITest() throws Exception {
        mockMvc.perform(get("/newGame/stein").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(view().name("newGame"));

        mockMvc.perform(get("/newGame/papier").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(view().name("newGame"));

        mockMvc.perform(get("/newGame/brunnen").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(view().name("newGame"));
    }
}
