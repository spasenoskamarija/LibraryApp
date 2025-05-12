import axiosInstance  from "../axios/axios.js"

const countriesRepository = {
    findAll: async () => {
        return await axiosInstance.get("/countries");
    },
    findById: async(id) => {
        return await axiosInstance.get(`/countries/${id}`)
    },
    create: async (country) => {
        return await axiosInstance.post("/countries/add",country);
    },
    update: async (id, country) => {
        return await axiosInstance.put(`/countries/edit/${id}`, country);
    },
    delete: async (id) => {
        return await axiosInstance.delete(`/countries/delete/${id}`);
    },

};

export default countriesRepository;
