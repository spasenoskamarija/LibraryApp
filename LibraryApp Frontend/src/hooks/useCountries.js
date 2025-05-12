import {useCallback, useEffect, useState} from "react";
import countryRepository from "../repository/countriesRepository.js";

const initialState = {
    "countries": [],
    "loading": true,
};

const useCountries = () => {
    const [state, setState] = useState(initialState);

    const fetchCountries = useCallback(() => {
        countryRepository
            .findAll()
            .then((response) => {
                setState({
                    "countries": response.data,
                    "loading": false,
                });
            })
            .catch((error) => console.log(error));
    }, []);

    const onAdd = useCallback((data) => {
        countryRepository
            .create(data)
            .then(() => {
                console.log("Added a new country");
                fetchCountries();
            })
            .catch((error) => console.log(error));
    }, [fetchCountries]);

    useEffect(() => {
        fetchCountries();
    }, [fetchCountries]);

    const onDelete = useCallback((id)=>{
        countryRepository
            .delete(id)
            .then(()=>{
                console.log(`Successfully deleted the country with ID ${id}`)
                fetchCountries();
            })
            .catch((error)=>console.log(error));
    },[fetchCountries]);


    const onEdit = useCallback((id,data)=>{
        countryRepository
            .update(id,data)
            .then(()=>{
                console.log(`Successfully edited the country with ID ${id}`)
                fetchCountries();
            })
            .catch((error)=>console.log(error));
    },[fetchCountries]);


    useEffect(()=>{
        fetchCountries();
    },[fetchCountries]);

    return {...state,onAdd:onAdd, onDelete:onDelete, onEdit:onEdit};

};

export default useCountries;