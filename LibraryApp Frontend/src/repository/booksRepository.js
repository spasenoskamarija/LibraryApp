import axiosInstance from "../axios/axios.js";

const booksRepository={
    findAll:async()=>{
        return await axiosInstance.get("/books");
    },
    findById: async(id)=>{
        return await axiosInstance.get(`/books/${id}`);
    },
    create: async (book)=>{
        return await axiosInstance.post("/books/add",book);
    },
    update:async (id, book)=>{
        return await axiosInstance.put(`/books/edit/${id}`,book);
    },
    delete:async(id)=>{
        return await axiosInstance.delete(`/books/delete/${id}`);
    }
}

export default booksRepository;