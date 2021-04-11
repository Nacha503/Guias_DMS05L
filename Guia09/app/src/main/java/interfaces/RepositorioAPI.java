package interfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Path;
import models.Repositorio;
import retrofit2.http.GET;


public interface RepositorioAPI {

    @GET("/users/{username}/repos")
    public Call<List<Repositorio>> getRepositorios(@Path("username") String username);
}
