/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

import javax.swing.JOptionPane;

import com.mycompany._usjt_psc_sistema.DAOS.GenreDAO;
import com.mycompany._usjt_psc_sistema.models.Genre;

/**
 *
 * @author 823212382
 */
public class GenreNames {
        public static String[] getGenreNames() {
                GenreDAO genreDAO = new GenreDAO();
                Genre[] genres = null;
                try {
                        genres = genreDAO.getGenres();
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro ao buscar gêneros: " + e.getMessage());
                }
                String[] genreNames = new String[genres.length];
                for (int i = 0; i < genres.length; i++) {
                        genreNames[i] = genres[i].getName();
                }
                ;

                return genreNames;
        }
}
