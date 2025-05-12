import React, {useState} from 'react';
import {Box, CircularProgress,Button} from "@mui/material";
import BooksGrid from "../../components/BookComponent/BooksGrid/BooksGrid.jsx";
import useBooks from "../../hooks/useBooks.js";
import "./BooksPage.css";
import AddBookDialog from '../../components/BookComponent/AddBookDialog/AddBookDialog.jsx';

const BooksPage=()=>{
    const{books,loading,onDelete,onEdit,onAdd}=useBooks();
    const [addBookDialog, setAddBookDialog] = useState(false);

    return (
        <>

            <Box className="page-box">
                {loading && (
                    <Box className="progress-box">
                        <CircularProgress/>
                    </Box>
                )}

                {
                    !loading &&
                    <>
                        <Box sx={{display: "flex", justifyContent: "flex-end", mb: 2}}>
                            <Button variant="contained" color="primary" onClick={() => setAddBookDialog(true)}>
                                Add Book
                            </Button>
                        </Box>
                        <BooksGrid books={books} onEdit={onEdit} onDelete={onDelete} />
                    </>
                }
            </Box>
            <AddBookDialog
                open={addBookDialog}
                onClose={()=>setAddBookDialog(false)}
                onAdd={onAdd}
            />

        </>
    );

}
export default BooksPage;