package com.villacis.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Jeferson Villacis
 * @version 1.0
 * @since 26/10/2026 Copyright 2026
 */
@WebMvcTest(PipelineController.class)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class PipelineControllerTest {
  private final MockMvc mockMvc;

  public PipelineControllerTest(MockMvc mockMvc) {
    this.mockMvc = mockMvc;
  }

  @Test
  void shouldReturnOkAndCorrectJsonStructure() throws Exception {
    mockMvc
        .perform(get("/api/status").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.status").value("UP"))
        .andExpect(jsonPath("$.environment").value("OpenShift Sandbox"))
        .andExpect(jsonPath("$.message").value("Pipeline successfully executed"));
  }
}
