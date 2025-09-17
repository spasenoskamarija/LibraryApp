import {useState} from "react";
import useAuthor from "../../../hooks/useAuthors.js";
import {
    Button,
    Dialog,
    DialogActions,
    DialogContent,
    DialogTitle,
    FormControl,
    InputLabel, MenuItem, Select,
    TextField
} from "@mui/material";

const EditBookDialog = ({open, onClose, book, onEdit }) => {
    const [formData, setFormData] = useState({
        "name": book.name,
        "authorId": book.authorId,
        "category": book.category,
        "availableCopies": book.availableCopies,
    });

    const { authors = [], loading } = useAuthor();

    const categories = [
        "NOVEL",
        "THRILLER",
        "HISTORY",
        "FANTASY",
        "BIOGRAPHY",
        "CLASSICS",
        "DRAMA"
    ];

    const handleChange = (event) => {
        const { name, value } = event.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSubmit = () => {
        onEdit(book.id, formData);
        setFormData(formData);
        onClose();
    };

    return (
        <Dialog open={open} onClose={onClose}>
            <DialogTitle>Edit Book</DialogTitle>
            <DialogContent>
                <TextField
                    margin="dense"
                    label="Name"
                    name="name"
                    value={formData.name}
                    onChange={handleChange}
                    fullWidth
                />
                <TextField
                    margin="dense"
                    label="Available Copies"
                    name="availableCopies"
                    type="number"
                    value={formData.availableCopies}
                    onChange={handleChange}
                    fullWidth
                />
                <FormControl fullWidth margin="dense">
                    <InputLabel>Category</InputLabel>
                    <Select
                        name="category"
                        value={formData.category}
                        onChange={handleChange}
                        label="Category"
                        variant="outlined"
                    >
                        {categories.map((category) => (
                            <MenuItem key={category} value={category}>
                                {category.charAt(0) + category.slice(1).toLowerCase()}
                            </MenuItem>
                        ))}
                    </Select>
                </FormControl>
                <FormControl fullWidth margin="dense">
                    <InputLabel>AuthorCard</InputLabel>
                    <Select
                        name="authorId"
                        value={formData.authorId}
                        onChange={handleChange}
                        label="AuthorCard"
                        variant="outlined"
                    >
                        {!loading && authors.map((author) => (
                            <MenuItem key={author.id} value={author.id}>
                                {author.name}
                            </MenuItem>
                        ))}
                    </Select>
                </FormControl>
            </DialogContent>
            <DialogActions>
                <Button onClick={onClose}>Cancel</Button>
                <Button onClick={handleSubmit} variant="contained" color="warning">Edit</Button>
            </DialogActions>
        </Dialog>
    );
};

export default EditBookDialog;