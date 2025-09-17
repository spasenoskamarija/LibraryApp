import { useCallback, useEffect, useState } from "react";
import booksRepository from "../repository/booksRepository.js";

const initialState = {
    "books": [],
    "loading": true,
};

const useBooks = () => {
    const[state, setState]=useState(initialState);

    const fetchBooks = useCallback(()=>{
        booksRepository.findAll()
            .then((response)=>{
                setState({
                    // koga ke dojde odgovor od backend togas datata od responsot ke se stavi vo books
                    "books":response.data,
                    "loading":false,
                })
            })
            .catch((error)=>console.log(error))
    },[]);

    const onAdd = useCallback((data)=>{
        booksRepository
            .create(data)
            .then(() => {
                console.log("Successfully added a new product.");
                fetchBooks();
            })
            .catch((error) => console.log(error));
    }, [fetchBooks]);


    const onDelete = useCallback((id)=>{
        booksRepository
            .delete(id)
            .then(()=>{
                console.log(`Successfully deleted the book with ID ${id}`)
                fetchBooks();
            })
            .catch((error)=>console.log(error));
    },[fetchBooks]);


    const onEdit = useCallback((id,data)=>{
        booksRepository
            .update(id,data)
            .then(()=>{
                console.log(`Successfully edited the book with ID ${id}`)
                fetchBooks();
            })
            .catch((error)=>console.log(error));
    },[fetchBooks]);


    useEffect(()=>{
        fetchBooks();
    },[fetchBooks]);
    return {...state,onAdd:onAdd, onDelete:onDelete, onEdit:onEdit};
};

export default useBooks;