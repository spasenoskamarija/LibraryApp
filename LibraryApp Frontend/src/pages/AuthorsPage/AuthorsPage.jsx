import React, {useState} from 'react';
import {Box, CircularProgress, Button} from "@mui/material";
import AuthorsGrid from "../../components/AuthorComponent/AuthorsGrid/AuthorsGrid.jsx";
import useAuthors from "../../hooks/useAuthors.js";
import "./AuthorsPage.css";
import AddAuthorDialog from "../../components/AuthorComponent/AddAuthorDialog/AddAuthorDialog.jsx";
import AuthorsPerCountryChart from "../../components/Charts/AuthorsPerCountryChart";

const AuthorsPage = () => {
    const { authors, loading, onDelete, onEdit, onAdd } = useAuthors();
    const [addAuthorDialog, setAddAuthorDialog] = useState(false);

    return (
        <>
            <Box className="page-box">
                {loading && (
                    <Box className="progress-box">
                        <CircularProgress/>
                    </Box>
                )}

                {!loading && (
                    <>
                        <Box sx={{ display: "flex", justifyContent: "flex-end", mb: 2 }}>
                            <Button variant="contained" color="primary" onClick={() => setAddAuthorDialog(true)}>
                                Add Author
                            </Button>
                        </Box>

                        {/* Табела со автори */}
                        <AuthorsGrid authors={authors} onEdit={onEdit} onDelete={onDelete} />

                        {/* Графиката: Authors per Country */}
                        <Box sx={{ mt: 5 }}>
                            <AuthorsPerCountryChart />
                        </Box>
                    </>
                )}
            </Box>

            <AddAuthorDialog
                open={addAuthorDialog}
                onClose={() => setAddAuthorDialog(false)}
                onAdd={onAdd}
            />
        </>
    );
};

export default AuthorsPage;
