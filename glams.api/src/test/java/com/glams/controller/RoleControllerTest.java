//package com.glams.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.glams.dto.request.RoleRequestDTO;
//import com.glams.dto.response.RoleResponseDTO;
//import com.glams.enums.RoleName;
//import com.glams.service.RoleService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(RoleController.class)
//class RoleControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Mock
//    private RoleService roleService;
//
//    private RoleRequestDTO roleRequest;
//    private RoleResponseDTO roleResponse;
//
//    @BeforeEach
//    void setUp() {
//        roleRequest = new RoleRequestDTO();
//        roleRequest.setName(RoleName.ADMIN);
//
//        roleResponse = new RoleResponseDTO();
//        roleResponse.setId(1L);
//        roleResponse.setName(RoleName.ADMIN);
//    }
//
//    @Test
//    void testCreateRole() throws Exception {
//        Mockito.when(roleService.createRole(any(RoleRequestDTO.class))).thenReturn(roleResponse);
//
//        mockMvc.perform(post("/api/roles")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(roleRequest)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1L))
//                .andExpect(jsonPath("$.name").value("ADMIN"));
//    }
//
//    @Test
//    void testGetRoleById() throws Exception {
//        Mockito.when(roleService.getRoleById(1L)).thenReturn(roleResponse);
//
//        mockMvc.perform(get("/api/roles/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(1L))
//                .andExpect(jsonPath("$.name").value("ADMIN"));
//    }
//
//    @Test
//    void testGetAllRoles() throws Exception {
//        Mockito.when(roleService.getAllRoles()).thenReturn(List.of(roleResponse));
//
//        mockMvc.perform(get("/api/roles")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].id").value(1L))
//                .andExpect(jsonPath("$[0].name").value("ADMIN"));
//    }
//
//    @Test
//    void testDeleteRole() throws Exception {
//        Mockito.doNothing().when(roleService).deleteRole(1L);
//
//        mockMvc.perform(delete("/api/roles/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNoContent());
//    }
//}
