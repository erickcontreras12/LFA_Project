/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofase1_lfa;

import Classes.*;
import java.util.ArrayList;

/**
 *
 * @author Erick Contreras
 */
public class ProyectoFase1_LFA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DFA dfa;
        ArrayList<Transition> t;
        ArrayList<State> s;
        //dfa = new DFA("a.b|c.d.(a.a|b.b)*", 1);
        dfa = new DFA("Len");
        System.out.println(dfa.getDFA());
    }
    
}