package com.example.app_kotlin_002

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app_kotlin_002.databinding.ViewMovieItemBinding

class MoviesAdapter (private val movies:List<Movie>,
                     private val movieClickedListener: (Movie) -> Unit):
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewMovieItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)

        return ViewHolder(binding)
    }

    override fun getItemCount() : Int{
        return movies.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Enlazamos el titulo y la imagen de cada item, es decir de cada pelicula
        //para esto necesitamos acceder a la posicion que estamos actualizando en el ViewHolder
        //holder.bind(movies[position])

        val movie = movies[position]

        holder.bind(movie)
        holder.itemView.setOnClickListener{
            movieClickedListener (movie)
        }
    }

    class ViewHolder (private val  binding: ViewMovieItemBinding): RecyclerView.ViewHolder(binding.root){
        //movie: es la pelicula que tenemos que cargar
        fun bind (movie: Movie){
            binding.textViewTitle.text = movie.title

            //
            //
            //
            Glide
                .with(binding.root.context)
                .load(movie.cover)
                .into(binding.imageViewCover)
        }
    }
}
/*
interface MovieClickedListener{
    //movie: para saber sobre que pelicula se a pulsado
    fun onMovieClicked (movie: Movie)   // (Movie)->Unit
}
 */







