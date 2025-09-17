import React from "react";
import {
    Dialog,
    DialogTitle,
    DialogContent,
    Typography,
    CardMedia,
    IconButton,
} from "@mui/material";
import CloseIcon from "@mui/icons-material/Close";

const BookInfoDialog = ({ book, open, onClose }) => {
    if (!book) return null;

    return (
        <Dialog open={open} onClose={onClose} maxWidth="sm" fullWidth>
            <DialogTitle sx={{ display: "flex", justifyContent: "space-between" }}>
                {book.title}
                <IconButton onClick={onClose}>
                    <CloseIcon />
                </IconButton>
            </DialogTitle>
            <DialogContent>
                <Typography variant="body2" sx={{ mt: 2 }}>
                    <b>Description:</b> {book.description || "No description available."}
                </Typography>
            </DialogContent>
        </Dialog>
    );
};

export default BookInfoDialog;
