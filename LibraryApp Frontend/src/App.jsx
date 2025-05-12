import BooksPage from "./pages/BooksPage/BooksPage.jsx";
import {BrowserRouter, Routes, Route} from "react-router";
import Layout from "./pages/Layout/Layout.jsx";
import AuthorsPage from "./pages/AuthorsPage/AuthorsPage.jsx";
import CountriesPage from "./pages/CountriesPage/CountriesPage.jsx"
import HomePage from "./pages/HomePage/HomePage.jsx";

const App = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Layout/>}>
                    <Route index element={<HomePage/>}/>
                    <Route path="countries" element={<CountriesPage/>}/>
                    <Route path="authors" element={<AuthorsPage/>}/>
                    <Route path="books" element={<BooksPage />}/>
                </Route>
            </Routes>
        </BrowserRouter>
    );
};

export default App;
