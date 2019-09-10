package com.spring.controllers;

import com.model.ExampleTableModel;
import com.spring.services.ExampleTableService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ExampleTableModelRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExampleTableService exampleTableService;

    private ExampleTableModel firstTable;
    private ExampleTableModel secondTable;
    private ExampleTableModel thirdTable;

    @Before
    public void init() {
        firstTable = new ExampleTableModel((long) 1, "w1", "w1", "w1", (long) 1);
        secondTable = new ExampleTableModel((long) 1, "w2", "w2", "w2", (long) 1);
        thirdTable = new ExampleTableModel((long) 1, "w1", "w3", "w3", (long) 1);
    }


    @Test
    public void getAllTablesTest() throws Exception {
        when(exampleTableService.findAll()).thenReturn(Arrays.asList(firstTable, secondTable, thirdTable));
        this.mockMvc.perform(get("/tables").contentType(APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(3)))

                .andExpect(jsonPath("$[0].id", is(Math.toIntExact(firstTable.getId()))))
                .andExpect(jsonPath("$[0].kolumna1", is(firstTable.getKolumna1())))
                .andExpect(jsonPath("$[0].kolumna2", is(firstTable.getKolumna2())))
                .andExpect(jsonPath("$[0].kolumna3", is(firstTable.getKolumna3())))
                .andExpect(jsonPath("$[0].kolumna4", is(Math.toIntExact(firstTable.getKolumna4()))))

                .andExpect(jsonPath("$[1].id", is(Math.toIntExact(secondTable.getId()))))
                .andExpect(jsonPath("$[1].kolumna1", is(secondTable.getKolumna1())))
                .andExpect(jsonPath("$[1].kolumna2", is(secondTable.getKolumna2())))
                .andExpect(jsonPath("$[1].kolumna3", is(secondTable.getKolumna3())))
                .andExpect(jsonPath("$[1].kolumna4", is(Math.toIntExact(secondTable.getKolumna4()))))

                .andExpect(jsonPath("$[2].id", is(Math.toIntExact(thirdTable.getId()))))
                .andExpect(jsonPath("$[2].kolumna1", is(thirdTable.getKolumna1())))
                .andExpect(jsonPath("$[2].kolumna2", is(thirdTable.getKolumna2())))
                .andExpect(jsonPath("$[2].kolumna3", is(thirdTable.getKolumna3())))
                .andExpect(jsonPath("$[2].kolumna4", is(Math.toIntExact(thirdTable.getKolumna4()))))

                .andExpect(status().isOk());

    }

    @Test
    public void getUniqueTables() throws Exception {
        when(exampleTableService.getUniqueTables("kolumna1")).thenReturn(Arrays.asList(secondTable));
        this.mockMvc.perform(get("/tables/uniqueTable/kolumna1").contentType(APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(1)))

                .andExpect(jsonPath("$[0].id", is(Math.toIntExact(secondTable.getId()))))
                .andExpect(jsonPath("$[0].kolumna1", is(secondTable.getKolumna1())))
                .andExpect(jsonPath("$[0].kolumna2", is(secondTable.getKolumna2())))
                .andExpect(jsonPath("$[0].kolumna3", is(secondTable.getKolumna3())))
                .andExpect(jsonPath("$[0].kolumna4", is(Math.toIntExact(secondTable.getKolumna4()))))


                .andExpect(status().isOk());

    }

    @Test
    public void getRepeatedTables() throws Exception {
        when(exampleTableService.getRepeatedTables("kolumna1")).thenReturn(Arrays.asList(firstTable, thirdTable));
        this.mockMvc.perform(get("/tables/repeatedTable/kolumna1").contentType(APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))

                .andExpect(jsonPath("$[0].id", is(Math.toIntExact(firstTable.getId()))))
                .andExpect(jsonPath("$[0].kolumna1", is(firstTable.getKolumna1())))
                .andExpect(jsonPath("$[0].kolumna2", is(firstTable.getKolumna2())))
                .andExpect(jsonPath("$[0].kolumna3", is(firstTable.getKolumna3())))
                .andExpect(jsonPath("$[0].kolumna4", is(Math.toIntExact(firstTable.getKolumna4()))))

                .andExpect(jsonPath("$[1].id", is(Math.toIntExact(thirdTable.getId()))))
                .andExpect(jsonPath("$[1].kolumna1", is(thirdTable.getKolumna1())))
                .andExpect(jsonPath("$[1].kolumna2", is(thirdTable.getKolumna2())))
                .andExpect(jsonPath("$[1].kolumna3", is(thirdTable.getKolumna3())))
                .andExpect(jsonPath("$[1].kolumna4", is(Math.toIntExact(thirdTable.getKolumna4()))))

                .andExpect(status().isOk());

    }

}
