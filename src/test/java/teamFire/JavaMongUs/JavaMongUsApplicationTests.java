package teamFire.JavaMongUs;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import teamFire.JavaMongUs.controllers.ApplicationUserController;
import teamFire.JavaMongUs.models.user.ApplicationUser;

// manual imports
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

// matchers
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class JavaMongUsApplicationTests {

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private MockMvc mockMvc;

	@Before("")
	public void setup(){
		mockMvc = MockMvcBuilders
				.webAppContextSetup(context)
				.apply(springSecurity())
				.build();
	}

	@Autowired
	private ApplicationUserController applicationUserController;

	@Test
	void contextLoads() {
	}

	@Test
	public void homePageRendersWithH1FormAndSection() throws Exception{
		this.mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("<h1>JavaMongUs HomePage</h1>")))
				.andExpect(content().string(containsString("<form action=\"/newuser\" method=\"POST\">")));
	}

//	@Test
//	public void loginPageRendersWithH1andForm

}
