package interfaces;

import java.util.List;

import models.Repositorio;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RepositorioAPI {
    @GET("/users/{username}/repos")
    public Call<List<Repositorio>> find(@Path("username") String username);
}
