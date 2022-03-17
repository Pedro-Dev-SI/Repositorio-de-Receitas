package com.api.backend.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.backend.data.DetalheUsuarioData;
import com.api.backend.model.UsuarioModel;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JWTAutenticarFilter extends UsernamePasswordAuthenticationFilter {

   public static final int TOKEN_EXPIRACAO = 600_000; // 10 minutos
   public static final String TOKEN_SENHA = "6c629803-9f18-4990-ac43-bb09dca85cc9";
   
   private final AuthenticationManager authenticationManager;

   public JWTAutenticarFilter(AuthenticationManager authenticationManager) {
      this.authenticationManager = authenticationManager;
   }

   @Override
   public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
      
      try{
         UsuarioModel usuarioModel = new ObjectMapper()
            .readValue(request.getInputStream(), UsuarioModel.class);

         return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            usuarioModel.getEmail(), 
            usuarioModel.getSenha(),
            new ArrayList<>()
         ));

      }catch(Exception e){
         throw new RuntimeException("Erro ao tentar autenticar usuário", e);
      }
      
   }

   @Override
   protected void successfulAuthentication(HttpServletRequest request, 
                                          HttpServletResponse response, FilterChain chain, 
                                          Authentication authResult) throws IOException, ServletException {
      
      
      DetalheUsuarioData usuarioData = (DetalheUsuarioData) authResult.getPrincipal();

      String token = JWT.create().
         withSubject(usuarioData.getUsername()).
         withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRACAO)).
         sign(Algorithm.HMAC512(TOKEN_SENHA));

      response.getWriter().write(token);
      response.getWriter().flush();

   }


}
