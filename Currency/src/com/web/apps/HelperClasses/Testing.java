package com.web.apps.HelperClasses;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.opensymphony.module.sitemesh.Factory;
import com.web.apps.model.Users;

public class Testing {
	
	@PersistenceContext(unitName="defaultPersistenceUnit")
	protected static EntityManager entityManager;
	
	public static void main(String[] args) {
/*		System.out.println("----running-------");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		System.out.println("----running-------33");
		Users U = em.find(Users.class,1);
		System.out.println(U);
		System.out.println("----running-------2");
		*/
		Users user=new Users();
		user.setNAME("Praveen");
		user.setPASSWORD("123");
		user.setSTATUS("Active");
		user.setCREATEDDATE(new Date());
		user.setCREATEDBY("Praveen");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		long id=(Long) session.save(user);
		System.out.println("ID="+id);
		session.flush();
		
		/*
		Session session = entityManager.unwrap(Session.class);
		try {
			session.persist(user);
			session.flush();
			session.clear();
		} catch (RuntimeException re) {
			throw re;
		}
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/*  Here N=NoOfRows=5 
		1
	   3*2
	  4*5*6
	10*9*8*7
  11*12*13*14*15
				 */
		int N=4;
		int space=N;
		int count=1;
		for(int i=1;i<=N;i++){
			for(int s=1;s<space;s++){
				System.out.print(" ");
			}space--;
			for(int j=1 ; j<=(2*i-1) ; j++){
				if(j%2==0){
					System.out.print("*");
				}else{
					if(i%2==0){
						
					}
					System.out.print(count);
					count++;
				}
			}
			System.out.println("");
		}
		
		
		
		
		
		
		
		//Fibonacci Series
		//0,1,1,2,3,5,8,13,21.........
		/*int a=0,b=1,c=0;
		System.out.print(a+","+b);
		while(c<=100){
			c = a + b;
			System.out.print(","+c);
			a=b;
			b=c;
		}*/
		
		
		
		/*find maximum number 1's array*/
		/*int M[][] = {{0, 1, 1, 0, 1}, 
				{1, 1, 0, 1, 0}, 
				{0, 1, 1, 1, 0},
				{1, 1, 1, 1, 0},
				{1, 1, 1, 1, 1},
				{0, 0, 0, 0, 0}};
			printMaxSubSquare(M);*/
	}

	static void printMaxSubSquare(int M[][]){
		int i,j;
		int R = M.length;		 //no of rows in M[][]
		int C = M[0].length;	 //no of columns in M[][]
		int S[][] = new int[R][C];	 

		int max_of_s, max_i, max_j; 

		/* Set first column of S[][]*/
		for(i = 0; i < R; i++)
			S[i][0] = M[i][0];

		/* Set first row of S[][]*/
		for(j = 0; j < C; j++)
			S[0][j] = M[0][j];

		/* Construct other entries of S[][]*/
		for(i = 1; i < R; i++){
			for(j = 1; j < C; j++){
				if(M[i][j] == 1) 
					S[i][j] = Math.min(S[i][j-1],Math.min(S[i-1][j], S[i-1][j-1])) + 1;
				else
					S[i][j] = 0;
			} 
		}	 

		/* Find the maximum entry, and indexes of maximum entry in S[][] */
		max_of_s = S[0][0]; max_i = 0; max_j = 0;
		for(i = 0; i < R; i++) {
			for(j = 0; j < C; j++) {
				if(max_of_s < S[i][j]) {
					max_of_s = S[i][j];
					max_i = i; 
					max_j = j;
				}	 
			}				 
		}	 

		System.out.println("Maximum size sub-matrix is: ");
		for(i = max_i; i > max_i - max_of_s; i--) {
			for(j = max_j; j > max_j - max_of_s; j--) {
				System.out.print(M[i][j] + " ");
			} 
			System.out.println();
		} 
	}
}