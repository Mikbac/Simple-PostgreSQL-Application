package com.postgres.spring.controller;

import com.postgres.model.ExampleTableModel;
import com.postgres.spring.service.ExampleTableService;
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
                .andExpect(jsonPath("$[0].column1", is(firstTable.getColumn1())))
                .andExpect(jsonPath("$[0].column2", is(firstTable.getColumn2())))
                .andExpect(jsonPath("$[0].column3", is(firstTable.getColumn3())))
                .andExpect(jsonPath("$[0].column4", is(Math.toIntExact(firstTable.getColumn4()))))

                .andExpect(jsonPath("$[1].id", is(Math.toIntExact(secondTable.getId()))))
                .andExpect(jsonPath("$[1].column1", is(secondTable.getColumn1())))
                .andExpect(jsonPath("$[1].column2", is(secondTable.getColumn2())))
                .andExpect(jsonPath("$[1].column3", is(secondTable.getColumn3())))
                .andExpect(jsonPath("$[1].column4", is(Math.toIntExact(secondTable.getColumn4()))))

                .andExpect(jsonPath("$[2].id", is(Math.toIntExact(thirdTable.getId()))))
                .andExpect(jsonPath("$[2].column1", is(thirdTable.getColumn1())))
                .andExpect(jsonPath("$[2].column2", is(thirdTable.getColumn2())))
                .andExpect(jsonPath("$[2].column3", is(thirdTable.getColumn3())))
                .andExpect(jsonPath("$[2].column4", is(Math.toIntExact(thirdTable.getColumn4()))))

                .andExpect(status().isOk());

    }

    @Test
    public void getUniqueTables() throws Exception {
        when(exampleTableService.getUniqueTables("column1")).thenReturn(Arrays.asList(secondTable));
        this.mockMvc.perform(get("/tables/uniqueTable/column1").contentType(APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(1)))

                .andExpect(jsonPath("$[0].id", is(Math.toIntExact(secondTable.getId()))))
                .andExpect(jsonPath("$[0].column1", is(secondTable.getColumn1())))
                .andExpect(jsonPath("$[0].column2", is(secondTable.getColumn2())))
                .andExpect(jsonPath("$[0].column3", is(secondTable.getColumn3())))
                .andExpect(jsonPath("$[0].column4", is(Math.toIntExact(secondTable.getColumn4()))))

                .andExpect(status().isOk());

    }

    @Test
    public void getRepeatedTables() throws Exception {
        when(exampleTableService.getRepeatedTables("column1")).thenReturn(Arrays.asList(firstTable, thirdTable));
        this.mockMvc.perform(get("/tables/repeatedTable/column1").contentType(APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))

                .andExpect(jsonPath("$[0].id", is(Math.toIntExact(firstTable.getId()))))
                .andExpect(jsonPath("$[0].column1", is(firstTable.getColumn1())))
                .andExpect(jsonPath("$[0].column2", is(firstTable.getColumn2())))
                .andExpect(jsonPath("$[0].column3", is(firstTable.getColumn3())))
                .andExpect(jsonPath("$[0].column4", is(Math.toIntExact(firstTable.getColumn4()))))

                .andExpect(jsonPath("$[1].id", is(Math.toIntExact(thirdTable.getId()))))
                .andExpect(jsonPath("$[1].column1", is(thirdTable.getColumn1())))
                .andExpect(jsonPath("$[1].column2", is(thirdTable.getColumn2())))
                .andExpect(jsonPath("$[1].column3", is(thirdTable.getColumn3())))
                .andExpect(jsonPath("$[1].column4", is(Math.toIntExact(thirdTable.getColumn4()))))

                .andExpect(status().isOk());

    }

}
