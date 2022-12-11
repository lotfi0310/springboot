package tn.esprit.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.persistance.Etudiant;

@Aspect
@Component
@Slf4j
public class GeneralInterceptorAspect {

	//
	@AfterThrowing(value= "execution(* tn.esprit.controller.*.*(..)) ",throwing = "e")
	 void afterEtudiantretrieveByID(JoinPoint joinPoint,Exception e) {
		log.info("Etudiant does not exist"+e.getMessage());	
	}
	
	@AfterReturning(value="execution(* tn.esprit.controller.*.*(..))",returning = "etudiant")
	 void afterFindingEtudiant(JoinPoint joinPoint,Etudiant etudiant) { 
		log.info(" Aspect return(after return exist student) :"+etudiant);
	}
	
	@Pointcut(value="execution(* tn.esprit.controller.*.addEtudiant(..))")
	public void addEtudiantlogpointcut() {}
	
	@Before("addEtudiantlogpointcut()")
	void beforeaddEtudiant(JoinPoint joinPoint) {
		
		log.info("before adding student");
	}
	
}
