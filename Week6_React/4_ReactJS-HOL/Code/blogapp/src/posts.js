import React from "react";

class Posts extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
            error: null
        };
    }

    componentDidMount() {
        this.loadPosts();
    }

    loadPosts() {
        fetch("https://jsonplaceholder.typicode.com/posts")
            .then((response) => response.json())
            .then((data) => {
                this.setState({ posts: data });
            })
            .catch((error) => {
                this.setState({ error });
                console.error("Error fetching posts:", error);
            });
    }

    componentDidCatch(error, info) {
        alert("Something went wrong!");
        console.error("Error occurred:", error, info);
    }

    render() {
        const { posts, error } = this.state;

        if (error) {
            return <h2>Error loading posts</h2>;
        }

        return (
            <div>
                <h1>Posts</h1>
                {posts.map((post) => (
                    <div key={post.id}>
                        <h3>{post.title}</h3>
                        <p>{post.body}</p>
                        <hr />
                    </div>
                ))}
            </div>
        );
    }
}

export default Posts;
