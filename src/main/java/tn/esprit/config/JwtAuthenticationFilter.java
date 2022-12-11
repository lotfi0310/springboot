package tn.esprit.config;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import tn.esprit.services.classes.UserDetailsServiceImp;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsServiceImp userDetService;

    @Autowired
    private JwtUtils jwtUtils;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {


        final String requestTokenHeader = request.getHeader("Authorization");

        //System.out.println(requestTokenHeader);



        String username = null;
        String jwtToken = null;




        if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer")) {


            jwtToken = requestTokenHeader.substring(7);

            System.out.println(jwtToken);

            try {
                username = this.jwtUtils.extractUsername(jwtToken);

                System.out.println(username);


            }catch(ExpiredJwtException e) {

                e.printStackTrace();
                System.out.println("token expiré");

            }catch(Exception e) {

                e.printStackTrace();
                System.out.println("erreur");


            }



        }else {

            System.out.println("Invalid token, ne commence pas par bearer");



        }


        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){

            final UserDetails userDetails = this.userDetService.loadUserByUsername(username);

            if(this.jwtUtils.validateToken(jwtToken, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAut = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                usernamePasswordAut.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAut);


            }


        }else {

            System.out.println("Token non valid");


        }


        filterChain.doFilter(request, response);

    }
}
