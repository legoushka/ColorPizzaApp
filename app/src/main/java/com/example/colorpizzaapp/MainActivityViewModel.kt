package com.example.colorpizzaapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.colorpizzaapp.data.colorapi.ColorApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlin.math.floor

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun fetchColorList(colorApi: ColorApi?){
        colorApi?.let {
            compositeDisposable.add(colorApi.getColorList(generateRandomColors())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                        Log.e("TAG", it.colors.toString())
                    },
                    {

                    }
                ))
        }

    }

    fun generateRandomColors(): String {
        val randomVal = floor(Math.random() * 60)
        val color = hslToHex(randomVal, 100.0, 75.0)
        val secondaryColor = hslToHex(randomVal,100.0, 30.0)
        return "$color,$secondaryColor"
    }

    fun hslToHex(h: Double, s: Double, l: Double) : String {
        val l100 = l / 100;
        val a = (s * Math.min(l100, 1 - l100)) / 100;
        fun f (n: Double) : String{
            val k = (n + h / 30) % 12
            val color = l100 - a * Math.max(listOf<Double>(k - 3, 9 - k, 1.0).minOrNull()!!, -1.0)
            return Math.round(255 * color).toString(16).padStart(2, '0')
        };
        return "${f(0.0)}${f(8.0)}${f(4.0)}";
    }
}