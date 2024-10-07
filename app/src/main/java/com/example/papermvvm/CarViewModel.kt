package com.example.papermvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.paperdb.Paper

class CarViewModel : ViewModel() {

    private var _cars:MutableLiveData<List<CarModel>> = MutableLiveData()
    val cars:LiveData<List<CarModel>> = _cars

    init {
        _cars.value = Paper.book().read("cars")
    }

    fun addCar(carModel: CarModel){
        var carList = Paper.book().read<List<CarModel>>("cars")
        if(carList.isNullOrEmpty()){
            Paper.book().write("cars", arrayListOf(carModel))
            _cars.value = Paper.book().read<List<CarModel>>("cars") ?: arrayListOf()
        }else{
            Paper.book().write("cars", carList + carModel)
            _cars.value = carList + carModel
        }

    }

    fun getCars(){
        _cars.value = Paper.book().read<List<CarModel>>("cars") ?: arrayListOf()
    }
}