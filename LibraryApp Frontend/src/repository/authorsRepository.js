import axiosInstance from "../axios/axios.js";

const authorsRepository = {
    findAll: async() => {
        return await axiosInstance.get("/authors")
    },
    findById: async(id) => {
        return await axiosInstance.get(`/authors/${id}`)
    },
    create: async (author) => {
        return await axiosInstance.post("/authors/add",author);
    },
    update: async (id, author) => {
        return await axiosInstance.put(`/authors/edit/${id}`, author);
    },
    delete: async (id) => {
        return await axiosInstance.delete(`/authors/delete/${id}`);
    },
    by_country: async () => {
        return await axiosInstance.get("/authors/by-country")
    }
};

export default authorsRepository;